package servicio;

import modelo.*;
import java.util.ArrayList;

public class EmpleadoServicio {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado correctamente.");
    }

    public void mostrarEmpleados() {

        if (empleados.isEmpty()) {
            System.out.println("No existen registros.");
            return;
        }

        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("Pago: " + e.calcularPago());
        }
    }

    public boolean cedulaExiste(String cedula) {

        for (Empleado e : empleados) {

            if (e.getCedula().equals(cedula)) {
                return true;
            }
        }

        return false;
    }

    public void buscarPorCedula(String cedula) {

        boolean encontrado = false;

        for (Empleado e : empleados) {

            if (e.getCedula().equals(cedula)) {

                e.mostrarInformacion();
                System.out.println("Pago: " + e.calcularPago());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Registro no encontrado.");
        }
    }

    public void reemplazarInformacion(String cedula, String nuevoNombre) {

        boolean encontrado = false;

        for (Empleado e : empleados) {

            if (e.getCedula().equals(cedula)) {

                e.setNombre(nuevoNombre);

                System.out.println("Informacion actualizada.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void eliminarEmpleado(String cedula) {

        boolean encontrado = false;

        for (Empleado e : empleados) {

            if (e.getCedula().equals(cedula)) {

                empleados.remove(e);

                System.out.println("Empleado eliminado.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Empleado no encontrado.");
        }
    }

    public void calcularPagos() {

        for (Empleado e : empleados) {

            System.out.println(
                    e.getNombre() +
                            " - Pago: " +
                            e.calcularPago()
            );
        }
    }

        public void mostrarEstadisticas() {

        int totalMedicos = 0;
        int totalAdministrativos = 0;

        double pagoMedicos = 0;
        double pagoAdministrativos = 0;

        Empleado mayorIngreso = empleados.get(0);

        for (Empleado e : empleados) {

            if (e instanceof Medico) {

                totalMedicos++;
                pagoMedicos += e.calcularPago();
            }

            if (e instanceof Administrativo) {

                totalAdministrativos++;
                pagoAdministrativos += e.calcularPago();
            }

            if (e.calcularPago() > mayorIngreso.calcularPago()) {
                mayorIngreso = e;
            }
        }

        System.out.println("===== ESTADISTICAS =====");

        System.out.println("Total medicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdministrativos);
        System.out.println("Total empleados: " + empleados.size());

        System.out.println("Pago total medicos: " + pagoMedicos);
        System.out.println("Pago total administrativos: " + pagoAdministrativos);

        System.out.println(
                "Empleado con mayor ingreso: " +
                        mayorIngreso.getNombre()
        );

        System.out.println(
                "Ingreso: " +
                        mayorIngreso.calcularPago()
        );
    }
}