public class CondicionAmbiental {
    public String tipo; 
    public double valorMedio;
    public double variabilidad; 
    public String unidadMedida;

    public CondicionAmbiental(String tipo, double valorMedio, double variabilidad, String unidadMedida) {
        this.tipo = tipo;
        this.valorMedio = valorMedio;
        this.variabilidad = variabilidad;
        this.unidadMedida = unidadMedida;
    }

    public void afectarDistribucion() {
        System.out.println("El factor ambiental " + tipo + " afecta la distribucion de las plantas.");
    }

    public void compararConOtra(CondicionAmbiental otra) {
        System.out.println("Comparando " + tipo + " (" + valorMedio + unidadMedida + ") con " + 
                           otra.tipo + " (" + otra.valorMedio + otra.unidadMedida + ")");
    }

    public static void main(String[] args) {
        CondicionAmbiental clima = new CondicionAmbiental("Temperatura", 23.5, 4.0, " C");
        CondicionAmbiental humedad = new CondicionAmbiental("Humedad", 60.0, 10.0, "%");
        clima.afectarDistribucion();
        clima.compararConOtra(humedad);
    }
}
