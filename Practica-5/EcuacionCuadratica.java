package ecuacioncuadratica;

import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class EcuacionCuadratica {

    public static double[] leerCoeficientes() {
        Scanner scanner = new Scanner(System.in);
        double[] coeficientes = new double[3];
        System.out.print("Ingrese los valores de a, b, c: ");
        coeficientes[0] = scanner.nextDouble();  
        coeficientes[1] = scanner.nextDouble();  
        coeficientes[2] = scanner.nextDouble();  
        return coeficientes;
    }

    public static double getDiscriminante(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double getRaiz1(double a, double b, double discriminante) {
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }

    public static double getRaiz2(double a, double b, double discriminante) {
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }

    public static void ecuacion(double a, double b, double c) {
        if (a == 0) {
            System.out.println("El valor de 'a' no puede ser cero en una ecuacion cuadratica.");
            return;
        }
        
        double discriminante = getDiscriminante(a, b, c);

        if (discriminante > 0) {
            double r1 = getRaiz1(a, b, discriminante);
            double r2 = getRaiz2(a, b, discriminante);
            System.out.println("La ecuacion tiene dos raices: "+ r1+ r2);
        }
        else if (discriminante == 0) {
            double r1 = getRaiz1(a, b, discriminante);
            System.out.println("La ecuacion tiene una raiz: "+ r1);
        }
        else {
            System.out.println("La ecuacion no tiene raices reales");
        }
    }

    public static void main(String[] args) {
        double[] coeficientes = leerCoeficientes();
        double a = coeficientes[0];
        double b = coeficientes[1];
        double c = coeficientes[2];
        ecuacion(a, b, c);
    }
}
