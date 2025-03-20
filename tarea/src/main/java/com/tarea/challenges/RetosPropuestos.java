// package com.tarea.challenges;

// import com.tarea.domain.entity.Equipo;
// import com.tarea.domain.entity.Jugador;
// import com.tarea.domain.entity.ListaEquipos;

// import java.util.Comparator;
// import java.util.List;
// import java.util.function.BiConsumer;
// import java.util.function.Consumer;
// import java.util.function.Predicate;

// public class RetosPropuestos {

//     // a. Listado de Equipos Fundados Después del Año 2000:
//     public static void listarEquiposFundadosDespues2000(ListaEquipos listaEquipos) {
//         Predicate<Equipo> filtro = e -> Integer.parseInt(e.getYearFoundation()) > 2000;
//         listaEquipos.getEquipos().stream()
//                 .filter(filtro)
//                 .map(Equipo::getName)
//                 .forEach(System.out::println);
//     }

//     // b. Impresión de Nombres de Entrenadores:
//     public static void imprimirEntrenadores(ListaEquipos listaEquipos) {
//         Consumer<Equipo> imprimirCoach = e -> System.out.println(e.getCoach());
//         listaEquipos.getEquipos().forEach(imprimirCoach);
//     }

//     // c. Cálculo del Promedio de Edad de Jugadores por Equipo:
//     public static void calcularPromedioEdadJugadores(ListaEquipos listaEquipos){
//         BiConsumer<Equipo, List<Jugador>> promedioEdad = (equipo, jugadores) -> {
//                 double promedio = jugadores.stream()
//                     .mapToInt(j -> j.getAge())
//                     .average()
//                     .orElse(0);
//                 System.out.println(equipo.getName() + ": " + promedio + " años.");
//             };
//         listaEquipos.getEquipos().forEach(e -> promedioEdad.accept(e, e.getPlayers()));
//     }

//     // d. Listado de Equipos con Más de 20 Victorias:
//     public static void listarEquiposMas20Victorias(ListaEquipos listaEquipos){
//         Predicate<Equipo> filtro = e -> e.getStatistics().get(0).getPg() > 20;
//             listaEquipos.getEquipos().stream()
//                 .filter(filtro)
//                 .map(e -> e.getName())
//                 .forEach(System.out::println);
//     }

//     // e. Obtención del Jugador Más Alto de Cada Equipo:
//     public static void JugadorMasAltoPorEquipo(ListaEquipos listaEquipos){
//         listaEquipos.getEquipos().forEach(e -> {
//             e.getPlayers().stream()
//                 .max(Comparator.comparingInt(j -> j.getHeight()))
//                 .ifPresent(jugador -> System.out.println(e.getName() + ": " + jugador.getName() + " (" + jugador.getHeight() + " cm)"));
//         });
//     }

//     // f. Cálculo del Total de Goles por Equipo:
//     public static void calcularTotalGolesPorEquipo(ListaEquipos listaEquipos){
//         listaEquipos.getEquipos().forEach(e ->{
//             int totalGoles = e.getStatistics().get(0).getGf();
//             System.out.println(e.getName() + ": " + totalGoles + " goles a favor");
//         });
//     }
// }
