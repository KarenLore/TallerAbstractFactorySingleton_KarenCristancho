package com.tarea;

import com.tarea.application.usecase.Equipo.EquipoUseCase;
import com.tarea.application.usecase.Jugador.JugadorUseCase;
import com.tarea.infrastructure.database.ConnectionFactory;
import com.tarea.infrastructure.persistence.Equipo.EquipoRepositoryImpl;
import com.tarea.infrastructure.persistence.Jugador.JugadorRepositoryImpl;
import com.tarea.infrastructure.persistence.Estadistica.EstadisticaRepositoryImpl;
import com.tarea.application.usecase.Estadisticas.EstadisticasUseCase;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EquipoUseCase equipoUseCase = new EquipoUseCase(new EquipoRepositoryImpl(ConnectionFactory.crearConexion()));
        JugadorUseCase jugadorUseCase = new JugadorUseCase(new JugadorRepositoryImpl(ConnectionFactory.crearConexion()));
        EstadisticasUseCase estadisticasUseCase = new EstadisticasUseCase(new EstadisticaRepositoryImpl(ConnectionFactory.crearConexion()));

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestionar Equipos");
            System.out.println("2. Gestionar Jugadores");
            System.out.println("3. Gestionar Estadísticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarEquipos(scanner, equipoUseCase);
                    break;
                case 2:
                    gestionarJugadores(scanner, jugadorUseCase);
                    break;
                case 3:
                    gestionarEstadisticas(scanner, estadisticasUseCase);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void gestionarEquipos(Scanner scanner, EquipoUseCase equipoUseCase) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE EQUIPOS ---");
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Consultar Equipo");
            System.out.println("3. Actualizar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar Equipos");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Año de Fundación: ");
                    String year = scanner.nextLine();
                    System.out.print("Entrenador: ");
                    String coach = scanner.nextLine();
                    equipoUseCase.registrarEquipo(id, name, year, coach);
                    System.out.println("Equipo registrado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese ID del equipo: ");
                    int idEquipo = scanner.nextInt();
                    System.out.println(equipoUseCase.obtenerEquipo(idEquipo));
                    break;
                case 3:
                    System.out.print("ID del equipo a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nuevo Año de Fundación: ");
                    String newYear = scanner.nextLine();
                    System.out.print("Nuevo Entrenador: ");
                    String newCoach = scanner.nextLine();
                    equipoUseCase.actualizarEquipo(idUpdate, newName, newYear, newCoach);
                    System.out.println("Equipo actualizado.");
                    break;
                case 4:
                    System.out.print("ID del equipo a eliminar: ");
                    int idDelete = scanner.nextInt();
                    equipoUseCase.eliminarEquipo(idDelete);
                    System.out.println("Equipo eliminado.");
                    break;
                case 5:
                    System.out.println("Listado de Equipos:");
                    System.out.println(equipoUseCase.listarEquipo());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void gestionarJugadores(Scanner scanner, JugadorUseCase jugadorUseCase) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE JUGADORES ---");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Consultar Jugador");
            System.out.println("3. Actualizar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Dorsal: ");
                    int dorsal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String name = scanner.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Edad: ");
                    int age = scanner.nextInt();
                    System.out.print("Altura: ");
                    int height = scanner.nextInt();
                    System.out.print("Peso: ");
                    int weight = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Posición: ");
                    String position = scanner.nextLine();
                    jugadorUseCase.registrarJugador(dorsal, name, nationality, age, height, weight, position);
                    System.out.println("Jugador registrado.");
                    break;
                case 2:
                    System.out.print("Ingrese ID del jugador: ");
                    int idJugador = scanner.nextInt();
                    System.out.println(jugadorUseCase.obtenerJugador(idJugador));
                    break;
                case 3:
                    System.out.println("Función de actualizar jugador en construcción.");
                    break;
                case 4:
                    System.out.print("ID del jugador a eliminar: ");
                    int idDelete = scanner.nextInt();
                    jugadorUseCase.eliminarJugador(idDelete);
                    System.out.println("Jugador eliminado.");
                    break;
                case 5:
                    System.out.println("Listado de Jugadores:");
                    System.out.println(jugadorUseCase.listarJugador());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void gestionarEstadisticas(Scanner scanner, EstadisticasUseCase estadisticasUseCase) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE ESTADÍSTICAS ---");
            System.out.println("1. Registrar Estadística");
            System.out.println("2. Consultar Estadística");
            System.out.println("3. Listar Estadísticas");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Función de registrar estadísticas en construcción.");
                    break;
                case 2:
                    System.out.print("Ingrese ID de la estadística: ");
                    int idEstadistica = scanner.nextInt();
                    System.out.println(estadisticasUseCase.obtenerEstadistica(idEstadistica));
                    break;
                case 3:
                    System.out.println("Listado de Estadísticas:");
                    System.out.println(estadisticasUseCase.listarEstadisticas());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
}