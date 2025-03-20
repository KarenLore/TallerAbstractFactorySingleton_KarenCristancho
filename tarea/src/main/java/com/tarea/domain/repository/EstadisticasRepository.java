package com.tarea.domain.repository;

import java.util.List;

import com.tarea.domain.entity.Estadisticas;

public interface EstadisticasRepository {
    void guardar(Estadisticas estadisticas);
    Estadisticas buscarPorId(int id);
    List<Estadisticas> listarTodos();
    void actualizar(Estadisticas estadisticas);
    void eliminar(int id);
}
