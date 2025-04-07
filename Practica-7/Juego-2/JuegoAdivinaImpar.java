package aplicacion2;
/*
 * @author DAVID
 */
public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }
    @Override
    public boolean validaNumero(int numero) {
        if (numero >= 0 && numero <= 10 && numero % 2 != 0) {
            return true;
        } else {
            System.out.println("Error: el numero debe ser impar y entre 0 y 10.");
            return false;
        }
    }
}
