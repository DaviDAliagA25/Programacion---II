package practica4;

/**
 *
 * @author DAVID
 */
public class Practica4 {

    double calculararea (double radio){
        return Math.PI * radio * radio;
    } 
       
    double calculararea (double base, double altura){
        return base * altura;
    }
    
    double calculararea(double base, double altura, double triangulo){
        return (base * altura) / 2;
    }

    double calculararea(double base1, double base2, double altura, boolean trapecio){
        return ((base1 + base2) * altura) / 2;
    }

    double calculararea(double lado, double apotema, boolean pentagono){
        return (5 * lado * apotema) / 2;
    }

    public static void main(String[] args) {
        Practica4 f1 = new Practica4();
        Practica4 f2 = new Practica4();   
        Practica4 f3 = new Practica4();
        Practica4 f4 = new Practica4();
        Practica4 f5 = new Practica4();
        
        System.out.println("Circulo: "+ f1.calculararea(1));
        System.out.println("Rectangulo: "+ f2.calculararea(2,3));
        System.out.println("Triangulo Rectangulo: "+ f3.calculararea(3,5));
        System.out.println("Trapecio: "+ f4.calculararea(2,3,4));
        System.out.println("Pentagono: "+ f5.calculararea(2,4));
     }   
}
