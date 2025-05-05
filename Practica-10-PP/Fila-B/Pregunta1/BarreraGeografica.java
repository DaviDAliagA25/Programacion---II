public class BarreraGeografica {
    public String nombre; 
    public String tipo;  
    public String ubicacion; 
    public int dificultadDispersión; 

    public BarreraGeografica(String nombre, String tipo, String ubicacion, int dificultadDispersión) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.dificultadDispersión = dificultadDispersión;
    }

    public void restringeDispersion() {
        System.out.println("La barrera " + nombre + " limita la dispersion de plantas en " + ubicacion);
    }

    public void superablePorEspecie(String especie) {
        if (dificultadDispersión <= 3) {
            System.out.println("La especie " + especie + " puede superar la barrera " + nombre);
        } else {
            System.out.println("La especie " + especie + " no puede superar la barrera " + nombre);
        }
    }

    public static void main(String[] args) {
        BarreraGeografica b = new BarreraGeografica("Cordillera de los Andes", "Montaña", "Sudamerica", 7);
        b.restringeDispersion();
        b.superablePorEspecie("Araucaria araucana");
    }
}
