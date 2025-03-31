package vectortridimensional;
/*
 * @author DAVID
 */
public class VectorTridimensional { 
    public double x, y, z;

public VectorTridimensional(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
}

public VectorTridimensional suma(VectorTridimensional b) {
    return new VectorTridimensional(this.x + b.x, this.y + b.y, this.z + b.z);
}

public VectorTridimensional multiplicacionescalar(double r) {
    return new VectorTridimensional(r * this.x, r * this.y, r * this.z);
}

public double longitud() {
    return Math.sqrt(x * x + y * y + z * z);
}

public VectorTridimensional normal() {
    double mag = longitud();
    return new VectorTridimensional(x / mag, y / mag, z / mag);
}

public double productoescalar(VectorTridimensional b) {
    return this.x * b.x + this.y * b.y + this.z * b.z;
}

public VectorTridimensional productovectorial(VectorTridimensional b) {
    return new VectorTridimensional(
        this.y * b.z - this.z * b.y,
        this.z * b.x - this.x * b.z,
        this.x * b.y - this.y * b.x
    );
}
@Override
public String toString() {
    return "(" + x + ", " + y + ", " + z + ")";
}

public static void main(String[] args) {
    VectorTridimensional a = new VectorTridimensional(1, 2, 3);
    VectorTridimensional b = new VectorTridimensional(4, 5, 6);
    double scalar = 2.0;

    System.out.println("Suma de dos vectores: " + a.suma(b));
    System.out.println("Multiplicacion por escalar: " + a.multiplicacionescalar(scalar));
    System.out.println("Longitud de un vector: " + a.longitud());
    System.out.println("Normal de un vector: " + a.normal());
    System.out.println("Producto escalar: " + a.productoescalar(b));
    System.out.println("Producto vectorial: " + a.productovectorial(b));
}

}
