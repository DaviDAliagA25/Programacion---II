public class Gobierno {
    public String presidente;
    public String ministerio;
    public String regionFocal;
    public String respuesta;

    public Gobierno(String presidente, String ministerio, String regionFocal, String respuesta) {
        this.presidente = presidente;
        this.ministerio = ministerio;
        this.regionFocal = regionFocal;
        this.respuesta = respuesta;
    }

    public void evaluarDenuncia() {
        System.out.println("El gobierno de " + presidente + " evalua la denuncia en " + regionFocal);
    }

    public void proponerSolucion() {
        System.out.println("El " + ministerio + " propone: " + respuesta);
    }

    public static void main(String[] args) {
        Gobierno gob = new Gobierno("Luis Arce", "Ministerio de Medio Ambiente", "Lago Poopo y Potosi", "crear fondo de compensacion y control ambiental");
        gob.evaluarDenuncia();
        gob.proponerSolucion();
    }
}
