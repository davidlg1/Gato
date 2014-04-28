package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener{

    private JButton jugador, maquina;
    public Menu(){
        setTitle("Tipo de juego");
        setLocation(250,100);
        setSize(250,150);
        setLayout(new FlowLayout());
        jugador = new JButton("Jugador vs Jugador");
        jugador.addActionListener(this);
        add(jugador);
        maquina = new JButton("Jugador vs Maquina");
        maquina.addActionListener(this);
        add(maquina);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        if(boton.getText()=="Jugador vs Jugador"){
            Interfaz juego = new Interfaz();
            juego.setVisible(true);
        }else{
            Interfaz2 juego = new Interfaz2(false);
            juego.setVisible(true);
        }
    }
    
    public static void main(String [] args){
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
