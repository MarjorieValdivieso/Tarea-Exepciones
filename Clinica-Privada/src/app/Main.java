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

