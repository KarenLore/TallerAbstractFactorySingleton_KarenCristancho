package com.tarea.domain.repository;

import java.util.List;

import com.tarea.domain.entity.Equipo;

public interface EquipoRepository {
    void guardar(Equipo equipo);
    Equipo buscarPorId(int id);
    List<Equipo> listarTodos();
    void actualizar(Equipo cliente);
    void eliminar(int id);
}
