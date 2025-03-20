package com.tarea.application.usecase.Estadisticas;

import java.util.List;

import com.tarea.domain.entity.Estadisticas;
import com.tarea.domain.repository.EstadisticasRepository;

public class EstadisticasUseCase {
         private final EstadisticasRepository repository;

    public EstadisticasUseCase(EstadisticasRepository repository) {
        this.repository = repository;
    }

    public void registrarEstadistica(int pj, int pg, int pe, int pp, int gf, int gc, int tp) {
        Estadisticas estadisticas = new Estadisticas(pj, pg, pe, pp, gf, gc, tp);
        repository.guardar(estadisticas);
    }

    public Estadisticas obtenerEstadistica(int id) {
        return repository.buscarPorId(id);
    }

    public List<Estadisticas> listarEstadisticas() {
        return repository.listarTodos();
    }

    public void actualizarEstadistica(int pj, int pg, int pe, int pp, int gf, int gc, int tp) {
        Estadisticas estadisticas = new Estadisticas(pj, pg, pe, pp, gf, gc, tp);
        repository.actualizar(estadisticas);
    }

    public void eliminarEstadistica(int id) {
        repository.eliminar(id);
    }
}
