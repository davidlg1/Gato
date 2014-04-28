package codigo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Gato2 extends JPanel implements ActionListener
{
    private Cuadro tablero[];
    private IA_PC maquina;
    private boolean turno;
    public Gato2(boolean t)
    {
        setSize(300,300);
        this.setLayout(new GridLayout(0, 3));
        tablero = new Cuadro[9];
        for(int n = 0; n < 9 ; n++)
        {
                tablero[n] = new Cuadro(n);
                tablero[n].setBackground(Color.white);
                tablero[n].addActionListener(this);
                add(tablero[n]);
        }
        maquina = new IA_PC();
        turno=t;
        if(turno) movMaquina();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Cuadro cuadro = (Cuadro)e.getSource();
        for(int n = 0; n < 9 ; n++)
        {
            if(cuadro.getNumero()==n&&cuadro.isSelected()==false)
            {
                if(!turno)
                {
                    ImageIcon img = new ImageIcon("src\\recursos\\x.png");
                    cuadro.setIcon(img);
                    cuadro.setJugador(1);
                    cuadro.setSelected(true);
                    movMaquina();

                }else{
                    ImageIcon img = new ImageIcon("src\\recursos\\o.png");
                    cuadro.setIcon(img);
                    cuadro.setJugador(1);
                    cuadro.setSelected(true);
                    movMaquina();
                }
            }
        }
        terminado(tablero);
    }
    
    public void movMaquina(){
        int [] tablero = new int[9];
        for(int i=0;i<9;i++){
            tablero[i]=this.tablero[i].getJugador();
        }
        maquina.movimiento(tablero);
        maquina.movComputadora(maquina.arbol);
        if(turno)
        {
            ImageIcon img = new ImageIcon("src\\recursos\\x.png");
            this.tablero[maquina.arbol.mejorMovimiento].setIcon(img);
            this.tablero[maquina.arbol.mejorMovimiento].setJugador(2);
            this.tablero[maquina.arbol.mejorMovimiento].setSelected(true);
        }else{
            ImageIcon img = new ImageIcon("src\\recursos\\o.png");
            this.tablero[maquina.arbol.mejorMovimiento].setIcon(img);
            this.tablero[maquina.arbol.mejorMovimiento].setJugador(2);
            this.tablero[maquina.arbol.mejorMovimiento].setSelected(true);
        }
    }
    
    public void terminado( Cuadro[] tablero ){
        if ( tablero[0].getJugador() == tablero[1].getJugador() && tablero[0].getJugador() == tablero[2].getJugador() && tablero[0].getJugador() != 0 )
            fin(tablero[0].getJugador());
        else if ( tablero[3].getJugador() == tablero[4].getJugador() && tablero[3].getJugador() == tablero[5].getJugador()  && tablero[3].getJugador() != 0  )
            fin(tablero[3].getJugador());
        else if ( tablero[6].getJugador() == tablero[7].getJugador() && tablero[6].getJugador() == tablero[8].getJugador()  && tablero[6].getJugador() != 0 )
            fin(tablero[6].getJugador());
        /*Columnas*/
        else if( tablero[0].getJugador() == tablero[3].getJugador() && tablero[0].getJugador() == tablero[6].getJugador()  && tablero[0].getJugador() != 0 )
            fin(tablero[0].getJugador());
        else if ( tablero[1].getJugador() == tablero[4].getJugador() && tablero[1].getJugador() == tablero[7].getJugador()  && tablero[1].getJugador() != 0  )
            fin(tablero[1].getJugador());
        else if ( tablero[2].getJugador() == tablero[5].getJugador() && tablero[2].getJugador() == tablero[8].getJugador()  && tablero[2].getJugador() != 0 )
            fin(tablero[2].getJugador());
        /*Diagonales*/
        else if ( tablero[0].getJugador() == tablero[4].getJugador() && tablero[0].getJugador() == tablero[8].getJugador() && tablero[0].getJugador() !=0 )
            fin(tablero[0].getJugador());
        else if ( tablero[2].getJugador() == tablero[4].getJugador() && tablero[2].getJugador() == tablero[6].getJugador() && tablero[2].getJugador() != 0 )
            fin(tablero[2].getJugador());
    }
    
    public void fin(int j)
    {
        for(int n=0; n<9; n++)
        {
            tablero[n].setEnabled(false);
        }
        if(turno){
            if(j==2){
            ImageIcon img = new ImageIcon("src\\recursos\\x.png");
            JOptionPane.showMessageDialog(this, "Ganan", "Fin del juego", 1,img);
            }else{
                ImageIcon img = new ImageIcon("src\\recursos\\o.png");
                JOptionPane.showMessageDialog(this, "Ganan", "Fin del juego", 1,img);
            }
        }else{
            if(j==1){
            ImageIcon img = new ImageIcon("src\\recursos\\x.png");
            JOptionPane.showMessageDialog(this, "Ganan", "Fin del juego", 1,img);
            }else{
                ImageIcon img = new ImageIcon("src\\recursos\\o.png");
                JOptionPane.showMessageDialog(this, "Ganan", "Fin del juego", 1,img);
            }
        }
    }
}