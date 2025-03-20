package com.tarea.infrastructure.persistence.Estadistica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea.domain.entity.Estadisticas;
import com.tarea.domain.repository.EstadisticasRepository;
import com.tarea.infrastructure.database.ConnectionDb;

public class EstadisticaRepositoryImpl implements EstadisticasRepository{
    private final ConnectionDb connection;
    
    public EstadisticaRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Estadisticas estadisticas) {
        String sql = "INSERT INTO estadisticas (pj, pg, pe, pp, gf, gc, tp) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estadisticas.getPj());
            stmt.setInt(2, estadisticas.getPg());
            stmt.setInt(3, estadisticas.getPe());
            stmt.setInt(4, estadisticas.getPp());
            stmt.setInt(5, estadisticas.getGf());
            stmt.setInt(6, estadisticas.getGc());
            stmt.setInt(7, estadisticas.getTp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estadisticas buscarPorId(int id) {
        String sql = "SELECT * FROM estadisticas WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estadisticas(rs.getInt("pj"), rs.getInt("pg"), rs.getInt("pe"), rs.getInt("pp"), rs.getInt("gf"), rs.getInt("gc"), rs.getInt("tp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estadisticas> listarTodos() {
        List<Estadisticas> estadisticas = new ArrayList<>();
        String sql = "SELECT * FROM estadisticas";
        try (Connection conexion = connection.getConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estadisticas.add(new Estadisticas(rs.getInt("pj"), rs.getInt("pg"), rs.getInt("pe"), rs.getInt("pp"), rs.getInt("gf"), rs.getInt("gc"), rs.getInt("tp")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadisticas;
    }

    @Override
    public void actualizar(Estadisticas estadisticas) {
        String sql = "UPDATE estadisticas SET pj = ?, pg = ?, SET pe = ?, SET pp = ?, SET gf = ?, SET gc = ?,SET tp = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estadisticas.getPj());
            stmt.setInt(2, estadisticas.getPg());
            stmt.setInt(3, estadisticas.getPe());
            stmt.setInt(4, estadisticas.getPp());
            stmt.setInt(5, estadisticas.getGf());
            stmt.setInt(6, estadisticas.getGc());
            stmt.setInt(7, estadisticas.getTp());
                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estadisticas WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
