package d;
/**
 * @author DAVID
 */
public class A {
    public int x;
    public int z;

    public A(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public void incrementaXZ() {
        x++;
        z++;
    }

    public void incrementaZ() {
        z++;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }
}
