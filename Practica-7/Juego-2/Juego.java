ackage aplicacion2;
/*
 * @author DAVID
 */
public class Juego {
    public int numeroDeVidas;
    public int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        System.out.println("Reiniciando partida...");
    }

    public void actualizaRecord() {
        record++;
        System.out.println("Nuevo record actualizado. Record actual: " + record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        System.out.println("Te queda(n) " + numeroDeVidas + " vida(s).");
        return numeroDeVidas > 0;
    }
}
