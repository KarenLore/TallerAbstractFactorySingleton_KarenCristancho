package com.tarea.domain.repository;

import java.util.List;

import com.tarea.domain.entity.Jugador;

public interface JugadorRepository {
    void guardar(Jugador jugador);
    Jugador buscarPorId(int id);
    List<Jugador> listarTodos();
    void actualizar(Jugador jugador);
    void eliminar(int id);
}
