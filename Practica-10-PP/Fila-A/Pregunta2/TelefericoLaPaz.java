import java.util.*;

class LineaTeleferico {
    public String color;
    public String tramo;
    public int nroCabinas;
    public int nroEmpleados;
    public String[][] empleados = new String[100][3]; 
    public int[] edades = new int[100];
    public double[] sueldos = new double[100];

    public LineaTeleferico(String color, String tramo, int nroCabinas) {
        this.color = color;
        this.tramo = tramo;
        this.nroCabinas = nroCabinas;
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

    public void eliminarPorApellido(String apellido) {
        for (int i = 0; i < nroEmpleados; ) {
            if (empleados[i][1].equalsIgnoreCase(apellido) || empleados[i][2].equalsIgnoreCase(apellido)) {
                for (int j = i; j < nroEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                    edades[j] = edades[j + 1];
                    sueldos[j] = sueldos[j + 1];
                }
                nroEmpleados--;
            } else {
                i++;
            }
        }
    }

    public void transferirEmpleado(String nombre, LineaTeleferico destino) {
        for (int i = 0; i < nroEmpleados; i++) {
            if (empleados[i][0].equalsIgnoreCase(nombre)) {
                destino.agregarEmpleado(empleados[i][0], empleados[i][1], empleados[i][2], edades[i], sueldos[i]);
                for (int j = i; j < nroEmpleados - 1; j++) {
                    empleados[j] = empleados[j + 1];
                    edades[j] = edades[j + 1];
                    sueldos[j] = sueldos[j + 1];
                }
                nroEmpleados--;
                break;
            }
        }
    }

    public void mostrarEmpleadoMayorEdad() {
        int maxEdad = -1;
        for (int i = 0; i < nroEmpleados; i++) {
            if (edades[i] > maxEdad) {
                maxEdad = edades[i];
            }
        }
        System.out.println("Empleado(s) con mayor edad:");
        for (int i = 0; i < nroEmpleados; i++) {
            if (edades[i] == maxEdad) {
                System.out.println(Arrays.toString(empleados[i]) + " Edad: " + edades[i]);
            }
        }
    }

    public void mostrarEmpleadoMayorSueldo() {
        double maxSueldo = -1;
        for (int i = 0; i < nroEmpleados; i++) {
            if (sueldos[i] > maxSueldo) {
                maxSueldo = sueldos[i];
            }
        }
        System.out.println("Empleado(s) con mayor sueldo:");
        for (int i = 0; i < nroEmpleados; i++) {
            if (sueldos[i] == maxSueldo) {
                System.out.println(Arrays.toString(empleados[i]) + " Sueldo: " + sueldos[i]);
            }
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Linea " + color + " (" + tramo + ")");
        for (int i = 0; i < nroEmpleados; i++) {
            System.out.println(Arrays.toString(empleados[i]) + " Edad: " + edades[i] + " Sueldo: " + sueldos[i]);
        }
    }
}

public class TelefericoLaPaz {
    public static void main(String[] args) {
        LineaTeleferico roja = new LineaTeleferico("Roja", "Estacion Central  Cementerio  16 de Julio", 20);
        LineaTeleferico amarilla = new LineaTeleferico("Amarilla", "Ciudad Satelite  Mirador  Obrajes  San Jorge", 18);

        roja.agregarEmpleado("Pedro", "Rojas", "Luna", 35, 2500);
        roja.agregarEmpleado("Lucy", "Sosa", "Rios", 43, 3250);
        roja.agregarEmpleado("Ana", "Perez", "Rojas", 26, 2700);
        roja.agregarEmpleado("Saul", "Arce", "Calle", 29, 2500);

        System.out.println("Empleados Linea Roja:");
        roja.mostrarEmpleados();

        roja.eliminarPorApellido("Rojas");
        System.out.println("Despues de eliminar apellido 'Rojas':");
        roja.mostrarEmpleados();

        roja.transferirEmpleado("Saul", amarilla);
        System.out.println("Linea Roja despues de transferir a 'Saul':");
        roja.mostrarEmpleados();
        System.out.println("Linea Amarilla despues de recibir a 'Saul':");
        amarilla.mostrarEmpleados();

        System.out.println("Mayor edad en Linea Roja:");
        roja.mostrarEmpleadoMayorEdad();

        System.out.println("Mayor sueldo en Linea Roja:");
        roja.mostrarEmpleadoMayorSueldo();
    }
}
