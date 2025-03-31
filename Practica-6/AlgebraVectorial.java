package algebravectorial;
/*
 * @author DAVID
 */
public class AlgebraVectorial { 
    public double x, y, z;

public AlgebraVectorial(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
}

public static boolean esPerpendicularA(AlgebraVectorial a, AlgebraVectorial b) {
    return a.suma(b).magnitud() == a.resta(b).magnitud();
}

public static boolean esMutuamentePerpendicular(AlgebraVectorial a, AlgebraVectorial b) {
    return a.resta(b).magnitud() == b.resta(a).magnitud();
}

public static boolean esOrtogonal(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoPunto(b) == 0;
}

public static boolean verificaTeoremaPitagoras(AlgebraVectorial a, AlgebraVectorial b) {
    return a.suma(b).magnitudCuadrado() == (a.magnitudCuadrado() + b.magnitudCuadrado());
}

public static boolean esParalelo(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoCruz(b).magnitud() == 0;
}

public static boolean esParaleloProductoCruz(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoCruz(b).esCero();
}

public static AlgebraVectorial proyeccion(AlgebraVectorial a, AlgebraVectorial b) {
    double escalar = a.productoPunto(b) / b.productoPunto(b);
    return new AlgebraVectorial(escalar * b.x, escalar * b.y, escalar * b.z);
}

public static double componente(AlgebraVectorial a, AlgebraVectorial b) {
    return a.productoPunto(b) / Math.sqrt(b.productoPunto(b));
}

public AlgebraVectorial suma(AlgebraVectorial b) {
    return new AlgebraVectorial(this.x + b.x, this.y + b.y, this.z + b.z);
}

public AlgebraVectorial resta(AlgebraVectorial b) {
    return new AlgebraVectorial(this.x - b.x, this.y - b.y, this.z - b.z);
}

public double productoPunto(AlgebraVectorial b) {
    return this.x * b.x + this.y * b.y + this.z * b.z;
}

public AlgebraVectorial productoCruz(AlgebraVectorial b) {
    return new AlgebraVectorial(
        this.y * b.z - this.z * b.y,
        this.z * b.x - this.x * b.z,
        this.x * b.y - this.y * b.x
    );
}

public double magnitud() {
    return Math.sqrt(x * x + y * y + z * z);
}

public double magnitudCuadrado() {
    return x * x + y * y + z * z;
}

public boolean esCero() {
    return x == 0 && y == 0 && z == 0;
}

@Override
public String toString() {
    return "(" + x + ", " + y + ", " + z + ")";
}

public static void main(String[] args) {
    AlgebraVectorial a = new AlgebraVectorial(3, -3, 1);
    AlgebraVectorial b = new AlgebraVectorial(4, 9, 2);

    System.out.println("Si el vector a es ortogonal o perpendicular a b: |a + b|= |a - b| es " + esPerpendicularA(a, b));
    System.out.println("Si el vector a es mutuamente ortogonal a b: |a - b| = |b - a| es "  + esMutuamentePerpendicular(a, b));
    System.out.println("Si el vector a es ortogonal a b: a * b = 0 es " + esOrtogonal(a, b));
    System.out.println("Si el vector a es ortogonal a b: |a + b|^2 = |a|^2 + |b|^2 es " + verificaTeoremaPitagoras(a, b));
    System.out.println("Si el vector a es paralela a b: a = r*b es " + esParalelo(a, b));
    System.out.println("Si el vector a es paralela a b: a × b = 0  es " + esParaleloProductoCruz(a, b));
    System.out.println("Proyección de a sobre b: " + proyeccion(a, b));
    System.out.println("Componente de a en b: " + componente(a, b));
}
}
