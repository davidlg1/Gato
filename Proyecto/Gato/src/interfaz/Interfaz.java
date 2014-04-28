package interfaz;

import codigo.Gato;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Interfaz extends JFrame implements ActionListener{
    Gato pnlgato;
    JButton reinicio;
    public Interfaz()
    {
        setTitle("Jugador vs Jugador");
        setLocation(250,100);
        setSize(300,400);
        setLayout(null);
        pnlgato = new Gato();
        add(pnlgato);
        reinicio = new JButton("Juego nuevo");
        reinicio.setBounds(75, 320, 150, 25);
        reinicio.addActionListener(this);
        add(reinicio);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void reiniciarJuego(){
        dispose();
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        reiniciarJuego();
    }
    
}
