public class EmpresaMinera {
    public String nombre;
    public String actividad;
    public String region;
    public String contaminacion;

    public EmpresaMinera(String nombre, String actividad, String region, String contaminacion) {
        this.nombre = nombre;
        this.actividad = actividad;
        this.region = region;
        this.contaminacion = contaminacion;
    }

    public void compensar() {
        System.out.println("La empresa " + nombre + " compensa por la contaminacion de " + contaminacion + " en " + region);
    }

    public void detenerActividad() {
        System.out.println("La empresa " + nombre + " detiene sus actividades extractivas en la region " + region);
    }

    public static void main(String[] args) {
        EmpresaMinera empresa = new EmpresaMinera("MinerBol", "Extracción de zinc y plata", "Oruro", "Mercurio");
        empresa.compensar();
        empresa.detenerActividad();
    }
}
