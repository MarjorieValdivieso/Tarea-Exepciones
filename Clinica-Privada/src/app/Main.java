package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpleadoServicio servicio = new EmpleadoServicio();
        Validador validador = new Validador();

        int opcion = 0;

        do {

            try {

                System.out.println("\n===== CLINICA SALUD TOTAL =====");
                System.out.println("1. Registrar medico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cedula");
                System.out.println("5. Reemplazar informacion");
                System.out.println("6. Eliminar registro");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Mostrar estadisticas");
                System.out.println("9. Salir");

                System.out.print("Seleccione una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {

                    case 1:

                        System.out.println("\n===== REGISTRAR MEDICO =====");

                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();

                        if (servicio.cedulaExiste(cedula)) {
                            System.out.println("Error: cedula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        if (validador.campoVacio(nombre)) {
                            System.out.println("Nombre invalido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());

                        if (edad <= 0 || edad > 150) {
                            System.out.println("Edad invalida.");
                            break;
                        }

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        if (!validador.validarTelefono(telefono)) {
                            System.out.println("Telefono invalido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        if (!validador.validarCorreo(correo)) {
                            System.out.println("Correo invalido.");
                            break;
                        }

                        System.out.print("Especialidad: ");
                        String especialidad = sc.nextLine();

                        if (validador.campoVacio(especialidad)) {
                            System.out.println("Especialidad invalida.");
                            break;
                        }

                        System.out.print("Pacientes atendidos: ");
                        int pacientes = Integer.parseInt(sc.nextLine());

                        if (pacientes <= 0) {
                            System.out.println("Cantidad invalida.");
                            break;
                        }

                        System.out.print("Valor consulta: ");
                        double valorConsulta = Double.parseDouble(sc.nextLine());

                        if (valorConsulta <= 0) {
                            System.out.println("Valor invalido.");
                            break;
                        }
                        Medico medico = new Medico(
                                cedula,
                                nombre,
                                edad,
                                telefono,
                                correo,
                                especialidad,
                                pacientes,
                                valorConsulta
                        );
                        servicio.agregarEmpleado(medico);

                        break;

                    case 2:
                        System.out.println("\n===== REGISTRAR ADMINISTRATIVO =====");
                        System.out.print("Cedula: ");
                        String cedulaA = sc.nextLine();
                        if (servicio.cedulaExiste(cedulaA)) {
                            System.out.println("Error: cedula repetida.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nombreA = sc.nextLine();

                        if (validador.campoVacio(nombreA)) {
                            System.out.println("Nombre invalido.");
                            break;
                        }

                        System.out.print("Edad: ");
                        int edadA = Integer.parseInt(sc.nextLine());

                        if (edadA <= 0 || edadA > 150) {
                            System.out.println("Edad invalida.");
                            break;
                        }

                        System.out.print("Telefono: ");
                        String telefonoA = sc.nextLine();

                        if (!validador.validarTelefono(telefonoA)) {
                            System.out.println("Telefono invalido.");
                            break;
                        }

                        System.out.print("Correo: ");
                        String correoA = sc.nextLine();

                        if (!validador.validarCorreo(correoA)) {
                            System.out.println("Correo invalido.");
                            break;
                        }

                        System.out.print("Departamento: ");
                        String departamento = sc.nextLine();

                        if (validador.campoVacio(departamento)) {
                            System.out.println("Departamento invalido.");
                            break;
                        }
                        System.out.print("Horas trabajadas: ");
                        int horas = Integer.parseInt(sc.nextLine());

                        if (horas <= 0) {
                            System.out.println("Horas invalidas.");
                            break;
                        }
                        System.out.print("Valor por hora: ");
                        double valorHora = Double.parseDouble(sc.nextLine());

                        if (valorHora <= 0) {
                            System.out.println("Valor invalido.");
                            break;
                        }
                        Administrativo administrativo = new Administrativo(
                                cedulaA,
                                nombreA,
                                edadA,
                                telefonoA,
                                correoA,
                                departamento,
                                horas,
                                valorHora
                        );

                        servicio.agregarEmpleado(administrativo);

                        break;

                    case 3:

                        servicio.mostrarEmpleados();
                        break;

                    case 4:

                        System.out.print("Ingrese cedula: ");
                        String buscar = sc.nextLine();

                        servicio.buscarPorCedula(buscar);
                        break;

                    case 5:
                        System.out.print("Ingrese cedula: ");
                        String reemplazar = sc.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = sc.nextLine();
                        servicio.reemplazarInformacion(
                                reemplazar,
                                nuevoNombre
                        );

                        break;

                    case 6:

                        System.out.print("Ingrese cedula: ");
                        String eliminar = sc.nextLine();

                        servicio.eliminarEmpleado(eliminar);
                        break;

                    case 7:
                        servicio.calcularPagos();
                        break;

                    case 8:
                        servicio.mostrarEstadisticas();
                        break;

                    case 9:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:

                        System.out.println("Error: opcion invalida.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: ingrese valores numericos válidos."
                );

            } catch (Exception e) {

                System.out.println("Ocurrio un error.");
            }

        } while (opcion != 9);
    }
}