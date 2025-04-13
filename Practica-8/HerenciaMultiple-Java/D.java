package d;
/**
 * @author DAVID
 */
public class D {
    public A parteA;
    public B parteB;

    public D(int x, int y, int z) {
        parteA = new A(x, z);
        parteB = new B(y, z);
    }

    public void incrementaXYZ() {
        parteA.incrementaXZ();
        parteB.incrementaYZ();
    }

    public void mostrar() {
        System.out.println("x = " + parteA.getX());
        System.out.println("y = " + parteB.getY());
        System.out.println("z (A) = " + parteA.getZ());
        System.out.println("z (B) = " + parteB.getZ());
    }


    public static void main(String[] args) {
        D objeto = new D(1, 2, 3);  
        objeto.incrementaXYZ();     
        objeto.mostrar();           
    }
    
}
