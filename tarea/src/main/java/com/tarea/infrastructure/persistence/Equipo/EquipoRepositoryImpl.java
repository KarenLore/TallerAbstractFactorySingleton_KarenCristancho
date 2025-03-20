package com.tarea.infrastructure.persistence.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarea.domain.entity.Equipo;
import com.tarea.domain.repository.EquipoRepository;
import com.tarea.infrastructure.database.ConnectionDb;

public class EquipoRepositoryImpl implements EquipoRepository{
    private final ConnectionDb connection;
    
    public EquipoRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Equipo equipo) {
        String sql = "INSERT INTO equipo (id, name, yearFoundation, coach) VALUES (?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, equipo.getId());
            stmt.setString(2, equipo.getName());
            stmt.setString(3, equipo.getYearFoundation());
            stmt.setString(4, equipo.getCoach());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo buscarPorId(int id) {
        String sql = "SELECT * FROM equipo WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearFoundation"), rs.getString("coach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipo> listarTodos() {
        List<Equipo> equipo = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try (Connection conexion = connection.getConexion();
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipo.add(new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearFoundation"), rs.getString("coach")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }

    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipo SET name = ?, yearFoundation = ?, SET coach = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, equipo.getId());
                stmt.setString(2, equipo.getName());
                stmt.setString(3, equipo.getYearFoundation());
                stmt.setString(4, equipo.getCoach());
                stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql0 = "SELECT * FROM equipo WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql0)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String sql = "DELETE FROM equipo WHERE id = ?";
                    try (Connection conexion1 = connection.getConexion();
                        PreparedStatement stmt1 = conexion1.prepareStatement(sql)) {
                        stmt1.setInt(1, id);
                        stmt1.executeUpdate();
                        System.out.println("Equipo eliminado exitosamente.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Error el ID que ingresaste no existe.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error");
        }
    }
}
