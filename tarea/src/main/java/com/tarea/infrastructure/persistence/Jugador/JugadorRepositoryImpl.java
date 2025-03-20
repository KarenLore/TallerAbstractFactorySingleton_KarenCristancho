package com.tarea.infrastructure.persistence.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea.domain.entity.Jugador;
import com.tarea.domain.repository.JugadorRepository;
import com.tarea.infrastructure.database.ConnectionDb;

public class JugadorRepositoryImpl implements JugadorRepository{
    private final ConnectionDb connection;
    
    public JugadorRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Jugador jugador) {
        String sql = "INSERT INTO jugador (dorsal, name, nationality, age, height, weight, position) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, jugador.getDorsal());
            stmt.setString(2, jugador.getName());
            stmt.setString(3, jugador.getNationality());
            stmt.setInt(4, jugador.getAge());
            stmt.setInt(5, jugador.getHeight());
            stmt.setInt(6, jugador.getWeight());
            stmt.setString(7, jugador.getPosition());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jugador buscarPorId(int id) {
        String sql = "SELECT * FROM jugador WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Jugador(rs.getInt("dorsal"), rs.getNString("name"), rs.getNString("nationality"), rs.getInt("age"), rs.getInt("height"), rs.getInt("weight"), rs.getNString("position"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Jugador> listarTodos() {
        List<Jugador> jugador = new ArrayList<>();
        String sql = "SELECT * FROM jugador";
        try (Connection conexion = connection.getConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                jugador.add(new Jugador(rs.getInt("dorsal"), rs.getNString("name"), rs.getNString("nationality"), rs.getInt("age"), rs.getInt("height"), rs.getInt("weight"), rs.getNString("position")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }

    @Override
    public void actualizar(Jugador jugador) {
        String sql = "UPDATE estadisticas SET dorsal = ?, name = ?, SET nationality = ?, SET age = ?, SET height = ?, SET weight = ?,SET position = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, jugador.getDorsal());
            stmt.setString(2, jugador.getName());
            stmt.setString(3, jugador.getNationality());
            stmt.setInt(4, jugador.getAge());
            stmt.setInt(5, jugador.getHeight());
            stmt.setInt(6, jugador.getWeight());
            stmt.setString(7, jugador.getPosition());
                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipo WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
