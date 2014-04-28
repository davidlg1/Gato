package interfaz;

import codigo.Gato2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Interfaz2 extends JFrame implements ActionListener{
    Gato2 pnlgato;
    JButton reinicio;
    public boolean turno;
    public Interfaz2(boolean t)
    {
        setTitle("Jugador vs Maquina");
        setLocation(250,100);
        setSize(300,400);
        setLayout(null);
        pnlgato = new Gato2(t);
        add(pnlgato);
        reinicio = new JButton("Juego nuevo");
        reinicio.setBounds(75, 320, 150, 25);
        reinicio.addActionListener(this);
        add(reinicio);
        turno = t;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void reiniciarJuego(){
        Interfaz2 interfaz = new Interfaz2(!turno);
        interfaz.setVisible(true);
        dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        reiniciarJuego();
    }
}