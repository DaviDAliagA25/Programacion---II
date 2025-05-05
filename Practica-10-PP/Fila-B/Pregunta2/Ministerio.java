public class Ministerio {
    public String nombre;
    public String direccion;
    public int nroEmpleados;

    public String[][] empleados = new String[100][3]; 
    public int[] edades = new int[100];
    public double[] sueldos = new double[100];

    public Ministerio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nroEmpleados = 0;
    }

    public void agregarEmpleado(String nombre, String paterno, String materno, int edad, double sueldo) {
        empleados[nroEmpleados][0] = nombre;
        empleados[nroEmpleados][1] = paterno;
        empleados[nroEmpleados][2] = materno;
        edades[nroEmpleados] = edad;
        sueldos[nroEmpleados] = sueldo;
        nroEmpleados++;
    }

    public void eliminarPorEdad(int edadX) {
        int j = 0;
        for (int i = 0; i < nroEmpleados; i++) {
            if (edades[i] != edadX) {
                empleados[j] = empleados[i];
                edades[j] = edades[i];
                sueldos[j] = sueldos[i];
                j++;
            }
        }
        nroEmpleados = j;
    }

    public void transferirDesde(Ministerio otro, int index) {
        if (index < 0 || index >= otro.nroEmpleados) return;
        agregarEmpleado(otro.empleados[index][0], otro.empleados[index][1], otro.empleados[index][2],
                        otro.edades[index], otro.sueldos[index]);
        otro.eliminarPorIndice(index);
    }

    private void eliminarPorIndice(int index) {
        for (int i = index; i < nroEmpleados - 1; i++) {
            empleados[i] = empleados[i + 1];
            edades[i] = edades[i + 1];
            sueldos[i] = sueldos[i + 1];
        }
        nroEmpleados--;
    }

    public void mostrarConMenorEdad() {
        if (nroEmpleados == 0) return;
        int minEdad = edades[0];
        for (int i = 1; i < nroEmpleados; i++) {
            if (edades[i] < minEdad)
                minEdad = edades[i];
        }
        System.out.println("Empleados con menor edad (" + minEdad + " años):");
        for (int i = 0; i < nroEmpleados; i++) {
            if (edades[i] == minEdad) {
                System.out.println(empleados[i][0] + " " + empleados[i][1] + " " + empleados[i][2]);
            }
        }
    }

    public void mostrarConMenorSueldo() {
        if (nroEmpleados == 0) return;
        double minSueldo = sueldos[0];
        for (int i = 1; i < nroEmpleados; i++) {
            if (sueldos[i] < minSueldo)
                minSueldo = sueldos[i];
        }
        System.out.println("Empleados con menor sueldo (" + minSueldo + " Bs):");
        for (int i = 0; i < nroEmpleados; i++) {
            if (sueldos[i] == minSueldo) {
                System.out.println(empleados[i][0] + " " + empleados[i][1] + " " + empleados[i][2]);
            }
        }
    }

    public void mostrarTodo() {
        System.out.println("Ministerio: " + nombre + " | Direccion: " + direccion);
        for (int i = 0; i < nroEmpleados; i++) {
            System.out.println((i + 1) + ". " + empleados[i][0] + " " + empleados[i][1] + " " + empleados[i][2] +
                    " | Edad: " + edades[i] + " | Sueldo: " + sueldos[i]);
        }
    }

    public static void main(String[] args) {
        Ministerio salud = new Ministerio("Ministerio de Salud y Deportes", "Av. Arce, La Paz");
        salud.agregarEmpleado("Carlos", "Mamani", "Quispe", 35, 3200);
        salud.agregarEmpleado("Ana", "Lopez", "Zapata", 28, 2900);
        salud.agregarEmpleado("Luis", "Condori", "Choque", 30, 2700);

        Ministerio educacion = new Ministerio("Ministerio de Educacion", "Calle Ayacucho, La Paz");
        educacion.agregarEmpleado("Maria", "Flores", "Rojas", 25, 2600);
        educacion.agregarEmpleado("Pablo", "Ticona", "Huanca", 29, 3100);

        System.out.println("=== Estado Inicial ===");
        salud.mostrarTodo();
        educacion.mostrarTodo();

        salud.eliminarPorEdad(30);
        System.out.println("Despues de eliminar empleados con edad 30 (Ministerio de Salud):");
        salud.mostrarTodo();

        salud.transferirDesde(educacion, 0);
        System.out.println("Despues de transferir un empleado de Educacion a Salud:");
        salud.mostrarTodo();
        educacion.mostrarTodo();
       
        salud.mostrarConMenorEdad();

        salud.mostrarConMenorSueldo();
    }
}
