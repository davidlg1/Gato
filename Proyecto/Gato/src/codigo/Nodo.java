package codigo;

/*Árboles para los movimientos del Gato.*/
public class Nodo {
    /*Mejor movimiento.*/
        int mejorMovimiento;
        /*Nodos hijos.*/
        Nodo nodos[];
        /*Tablero del juego.*/
        public int tablero[];
        /*Turno de la computadora.*/
        boolean miTurno = false;
        /*Indice de la pocision.*/
        int indice;
        /*Ganador.*/
        int ganador = 0;

        /*Constructor.*/
        Nodo(){
            
            /*Inicializamos las variables.*/
            tablero = new int[9];
               
        }
}
