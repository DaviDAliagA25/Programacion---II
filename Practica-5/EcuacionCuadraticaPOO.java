package ecuacioncuadraticapoo;

import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class EcuacionCuadraticaPOO {
    public double a;
    public double b;
    public double c;

    public EcuacionCuadraticaPOO(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public Double getRaiz1() {
        double discriminante = getDiscriminante();
        if (discriminante >= 0) {
            return (-b + Math.sqrt(discriminante)) / (2 * a);
        }
        return null; 
    }

    public Double getRaiz2() {
        double discriminante = getDiscriminante();
        if (discriminante > 0) {
            return (-b - Math.sqrt(discriminante)) / (2 * a);
        }
        return null; 
    }

    public void resolver() {
        double discriminante = getDiscriminante();

        if (discriminante > 0) {
            Double r1 = getRaiz1();
            Double r2 = getRaiz2();
            System.out.println("La ecuacion tiene dos raices: "+ r1+ r2);
        } else if (discriminante == 0) {
            Double r1 = getRaiz1();
            System.out.println("La ecuacion tiene una raiz: "+ r1);
        } else {
            System.out.println("La ecuacion no tiene raices reales");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese los valores de a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        EcuacionCuadraticaPOO ecuacion = new EcuacionCuadraticaPOO(a, b, c);
        ecuacion.resolver();
    }
}
