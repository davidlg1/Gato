package codigo;

import javax.swing.JButton;

class Cuadro extends JButton{
    private int numero,jugador;
    public Cuadro(int n){
        numero=n;
        jugador = 0;
    }
    public int getNumero(){
        return numero;
    }
    public int getJugador(){
        return jugador;
    }
    public void setJugador(int j){
        jugador=j;
    }
}
