package aplicacion2;
/*
 * @author DAVID
 */
public class Aplicacion2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juegoPar = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juegoImpar = new JuegoAdivinaImpar(3);

        System.out.println("Juego normal:");
        juego1.juega();

        System.out.println("\nJuego de pares:");
        juegoPar.juega();

        System.out.println("\nJuego de impares:");
        juegoImpar.juega();
    }   
}
