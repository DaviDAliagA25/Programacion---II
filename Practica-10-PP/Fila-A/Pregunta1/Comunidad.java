public class Comunidad {
    public String nombre;
    public String ubicacion;
    public String contaminantes;
    public int poblacion;

    public Comunidad(String nombre, String ubicacion, String contaminantes, int poblacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.contaminantes = contaminantes;
        this.poblacion = poblacion;
    }

    public void denunciar() {
        System.out.println("La comunidad de " + nombre + " denuncia contaminacion por: " + contaminantes);
    }

    public void exigirFondo() {
        System.out.println("La comunidad de " + nombre + " exige un fondo de compensacion al Estado y empresas mineras.");
    }

    public static void main(String[] args) {
        Comunidad comunidad1 = new Comunidad("Tomas Frias", "Potosi", "Plomo, arsenico", 3500);
        comunidad1.denunciar();
        comunidad1.exigirFondo();
    }
}
