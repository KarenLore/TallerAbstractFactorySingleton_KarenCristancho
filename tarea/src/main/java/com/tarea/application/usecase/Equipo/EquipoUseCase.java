package com.tarea.application.usecase.Equipo;

import java.util.List;

import com.tarea.domain.entity.Equipo;
import com.tarea.domain.repository.EquipoRepository;

public class EquipoUseCase {
    private final EquipoRepository repository;

    public EquipoUseCase(EquipoRepository repository) {
        this.repository = repository;
    }

    public void registrarEquipo(int id, String name, String yearFoundation, String coach) {
        Equipo equipo = new Equipo(id, name, yearFoundation, coach);
        repository.guardar(equipo);
    }

    public Equipo obtenerEquipo(int id) {
        return repository.buscarPorId(id);
    }

    public List<Equipo> listarEquipo() {
        return repository.listarTodos();
    }

    public void actualizarEquipo(int id, String name, String yearFoundation, String coach) {
        Equipo equipo = new Equipo(id, name, yearFoundation, coach);
        repository.actualizar(equipo);
    }

    public void eliminarEquipo(int id) {
        repository.eliminar(id);
    }
}
