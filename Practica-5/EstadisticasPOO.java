package estadisticaspoo;

import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class EstadisticasPOO {
    public float[] numeros;

    public EstadisticasPOO(float[] numeros) {
        this.numeros = numeros;
    }

    public float calcularPromedio() {
        float suma = 0;
        for (float num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public float calcularDesviacion(float promedio) {
        float sumaCuadrados = 0;
        for (float num : numeros) {
            sumaCuadrados += Math.pow(num - promedio, 2);
        }
        return (float) Math.sqrt(sumaCuadrados / (numeros.length - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese 10 numeros separados por espacio: ");
        String input = scanner.nextLine();
        String[] numerosStr = input.split(" ");
        
        if (numerosStr.length != 10) {
            System.out.println("Debe ingresar exactamente 10 numeros.");
        } else {
            float[] numeros = new float[10];
            for (int i = 0; i < 10; i++) {
                numeros[i] = Float.parseFloat(numerosStr[i]);
            }

            EstadisticasPOO stats = new EstadisticasPOO(numeros);

            float promedio = stats.calcularPromedio();           
            float desviacion = stats.calcularDesviacion(promedio);

            System.out.printf("El promedio es: "+ promedio);
            System.out.printf("La desviacion estandar es: "+ desviacion);
        }
    }
}
