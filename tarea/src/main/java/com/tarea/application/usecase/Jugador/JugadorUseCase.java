package com.tarea.application.usecase.Jugador;

import java.util.List;

import com.tarea.domain.entity.Jugador;
import com.tarea.domain.repository.JugadorRepository;

public class JugadorUseCase {
     private final JugadorRepository repository;

    public JugadorUseCase(JugadorRepository repository) {
        this.repository = repository;
    }

    public void registrarJugador(int dorsal, String name, String nationality, int age, int height, int weight, String position) {
        Jugador jugador = new Jugador(dorsal, name, nationality, age, height, weight, position);
        repository.guardar(jugador);
    }

    public Jugador obtenerJugador(int id) {
        return repository.buscarPorId(id);
    }

    public List<Jugador> listarJugador() {
        return repository.listarTodos();
    }

    public void actualizarJugador(int dorsal, String name, String nationality, int age, int height, int weight, String position) {
        Jugador jugador = new Jugador(dorsal, name, nationality, age, height, weight, position);
        repository.actualizar(jugador);
    }

    public void eliminarJugador(int id) {
        repository.eliminar(id);
    }
}
