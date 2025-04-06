package aplicacion;

import java.util.Random;
import java.util.Scanner;
/*
 * @author DAVID
 */
public class JuegoAdivinaNumero extends Juego{
    public int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public void juega() {
        reiniciaPartida();
        Random rand = new Random();
        numeroAAdivinar = rand.nextInt(11); 

        Scanner sc = new Scanner(System.in);
        boolean sigueJugando = true;

        while (sigueJugando) {
            System.out.print("Adivina un numero entre 0 y 10: ");
            int intento = sc.nextInt();

            if (intento == numeroAAdivinar) {
                System.out.println("Acertaste");
                actualizaRecord();
                sigueJugando = false;
            } else {
                System.out.println("Numero incorrecto.");
                if (quitaVida()) {
                    if (intento < numeroAAdivinar) {
                        System.out.println("Pista: el numero es mayor.");
                    } else {
                        System.out.println("Pista: el numero es menor.");
                    }
                } else {
                    System.out.println("No te quedan mas vidas. Fin del juego.");
                    sigueJugando = false;
                }
            }
        }
    }
}
