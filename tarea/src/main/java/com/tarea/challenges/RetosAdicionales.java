package com.tarea.challenges;

import com.tarea.domain.entity.Equipo;
import com.tarea.domain.entity.ListaEquipos;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class RetosAdicionales {

    // 1. Listar equipos con más de 15 puntos en la fase de liga
    public static void listarEquiposMas15Puntos(ListaEquipos listaEquipos){
        Predicate<Equipo> filtro = e -> e.getStatistics().get(0).getTp() > 15;
        listaEquipos.getEquipos().stream()
            .filter(filtro)
            .map(e -> e.getName())
            .forEach(System.out::println);
    }

    // 2. Obtener el promedio de goles a favor por equipo
    public static void calcularPromedioGolesAFavor(ListaEquipos listaEquipos){
        double promedioGoles = listaEquipos.getEquipos().stream()
            .collect(Collectors.averagingInt(e -> e.getStatistics().get(0).getGf()));

            System.out.println("promedio de goles a favor: " + promedioGoles);
    }

    // 3. Mostrar el equipo con más victorias
    public static void encontrarEquipoMasVictorias(ListaEquipos listaEquipos){
        listaEquipos.getEquipos().stream()
            .max(Comparator.comparingInt(e -> e.getStatistics().get(0).getPg()))
            .ifPresent(equipo -> System.out.println("Equipo con más victorias: " + equipo.getName() + " (" + equipo.getStatistics().get(0).getPg() + " Victorias)."));
    }

    // 4. Encontrar el jugador más alto de todos los equipos
    public static void encontrarJugadorMasAlto(ListaEquipos listaEquipos){
        listaEquipos.getEquipos().stream()
        .flatMap(e -> e.getPlayers().stream())
        .max(Comparator.comparingInt(j -> j.getHeight()))
        .ifPresent(jugador -> System.out.println("Jugador más alto: " + jugador.getName() + " (" + jugador.getHeight() + " cm)."));
    }

    // 5. Contar cuántos jugadores son delanteros en toda la UEFA Champions League
    public static void contarDelanteros(ListaEquipos listaEquipos){
        long totalDelanteros = listaEquipos.getEquipos().stream()
        .flatMap(e -> e.getPlayers().stream())
        .filter(j -> j.getPosition().equals("Delantero"))
        .count();

        System.out.println("Total de delanteros: " + totalDelanteros);
    }

    // 6. Obtener los nombres de los entrenadores de los equipos que han empatado al menos un partido
    public static void obtenerEntrenadoresConEmpates(ListaEquipos listaEquipos){
        listaEquipos.getEquipos().stream()
            .filter(e -> e.getStatistics().get(0).getPe() > 0)
            .map(e -> e.getCoach())
            .forEach(System.out::println);
    }

    // 7. Crear un Map con los nombres de los equipos como clave y la cantidad total de goles a favor como valor
    public static void mapearGolesPorEquipo(ListaEquipos listaEquipos){
        Map<String, Integer> golesPorEquipo = listaEquipos.getEquipos().stream()
            .collect(Collectors.toMap(e -> e.getName(), e -> e.getStatistics().get(0).getGf()));

            golesPorEquipo.forEach((equipo, goles) -> System.out.println(equipo + ": " + goles));
    }

    // 8. Listar los jugadores de nacionalidad "Brasileño" y ordenarlos por edad
    public static void listarBrasileñosOrdenadosPorEdad(ListaEquipos listaEquipos){
        listaEquipos.getEquipos().stream()
        .flatMap(e -> e.getPlayers().stream())
        .filter(j -> j.getNationality().equals("Brasileño"))
        .sorted(Comparator.comparingInt(j -> j.getAge()))
        .forEach(j -> System.out.println(j.getName() + "-" + j.getAge() + " años"));
    }

    // 9. Filtrar los equipos cuyo entrenador tiene más de 10 caracteres en su nombre
    public static void filtrarEntrenadoresNombreLargo(ListaEquipos listaEquipos){
        listaEquipos.getEquipos().stream()
        .filter(e -> e.getCoach().length() > 10)
        .map(e -> e.getName() + " - " + e.getCoach())
        .forEach(System.out::println);
    }

    // 10. Determinar si algún equipo tiene más de 25 puntos
    public static void verificarEquipoMas25Puntos(ListaEquipos listaEquipos) {
        boolean existe = listaEquipos.getEquipos().stream()
            .anyMatch(e -> e.getStatistics().get(0).getTp() > 25);
        
    System.out.println("¿Algún equipo tiene más de 25 puntos? " + (existe ? "Sí" : "No"));
    }

    // 10.1. Agrupar los jugadores por posición y contar cuántos hay en cada una
    public static void contarJugadoresPorPosicion(ListaEquipos listaEquipos) {
        Map<String, Long> conteoPosiciones = listaEquipos.getEquipos().stream()
            .flatMap(e -> e.getPlayers().stream())
            .collect(Collectors.groupingBy(j -> j.getPosition(), Collectors.counting()));

        System.out.println("Jugadores por posición:");
        conteoPosiciones.forEach((posicion, cantidad) -> System.out.println(posicion + ": " + cantidad));
    }

    // 10.2. Obtener los equipos con más de 20 goles a favor ordenados de mayor a menor
    public static void listarEquiposMas20GolesOrdenados(ListaEquipos listaEquipos) {
        listaEquipos.getEquipos().stream()
            .filter(e -> e.getStatistics().get(0).getGf() > 20)  
            .sorted(Comparator.comparingInt(e -> -e.getStatistics().get(0).getGf()))  
            .forEach(e -> System.out.println(e.getName() + " - Goles a favor: " + e.getStatistics().get(0).getGf()));
    }
}

