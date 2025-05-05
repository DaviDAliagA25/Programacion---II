public class Planta {
    public String nombre;
    public String tipo; 
    public String region;
    public double antiguedadEvolutiva;

    public Planta(String nombre, String tipo, String region, double antiguedadEvolutiva) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.region = region;
        this.antiguedadEvolutiva = antiguedadEvolutiva;
    }

    public void adaptarseAmbiente() {
        System.out.println("La planta " + nombre + " se adapta al ambiente de la region " + region);
    }

    public void expandirseRegion() {
        System.out.println("La planta " + nombre + " intenta expandirse mas alla de " + region);
    }

    public static void main(String[] args) {
        Planta p = new Planta("Quercus robur", "Angiosperma", "Europa Occidental", 56.2);
        p.adaptarseAmbiente();
        p.expandirseRegion();
    }
}
