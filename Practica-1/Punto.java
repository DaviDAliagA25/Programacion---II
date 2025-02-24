public class Punto {
    public float x;
    public float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] coordCartesianas() {
        return new float[]{this.x, this.y};
    }
    public float[] coordPolares() {
        float radio = (float) Math.sqrt(this.x * this.x + this.y * this.y);
        float angulo = (float) Math.atan2(this.y, this.x); 
        angulo = (float) Math.toDegrees(angulo);
        return new float[]{radio, angulo};
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    public static void main(String[] args) {
        Punto p1 = new Punto(0, 3);

        System.out.println("Punto en coordenadas cartesianas: " + p1);
        
        float[] cartesianas = p1.coordCartesianas();
        System.out.println("Coordenadas cartesianas: " + cartesianas[0] + ", " + cartesianas[1]);

        float[] polares = p1.coordPolares();
        System.out.println("Coordenadas polares: Radio = " + polares[0] + ", Ángulo = " + polares[1] + "°");
    }
}
