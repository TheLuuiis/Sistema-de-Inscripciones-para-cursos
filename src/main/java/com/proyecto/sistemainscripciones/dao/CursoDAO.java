package com.proyecto.sistemainscripciones.dao;

import com.proyecto.sistemainscripciones.modelos.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public boolean insertar(Curso curso) {
        String sql = "INSERT INTO cursos (nombre, descripcion, cupo_maximo, fecha_inicio, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getCupoMaximo());
            ps.setString(4, curso.getFechaInicio());
            ps.setString(5, curso.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar curso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Curso> listarTodos() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos ORDER BY id";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Curso c = new Curso();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setCupoMaximo(rs.getInt("cupo_maximo"));
                c.setFechaInicio(rs.getString("fecha_inicio"));
                c.setEstado(rs.getString("estado"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar cursos: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    public Curso buscarPorId(int id) {
        String sql = "SELECT * FROM cursos WHERE id = ?";
        Curso c = null;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Curso();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setDescripcion(rs.getString("descripcion"));
                    c.setCupoMaximo(rs.getInt("cupo_maximo"));
                    c.setFechaInicio(rs.getString("fecha_inicio"));
                    c.setEstado(rs.getString("estado"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar curso: " + e.getMessage());
            e.printStackTrace();
        }

        return c;
    }

    public boolean actualizar(Curso curso) {
        String sql = "UPDATE cursos SET nombre = ?, descripcion = ?, cupo_maximo = ?, fecha_inicio = ?, estado = ? WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getCupoMaximo());
            ps.setString(4, curso.getFechaInicio());
            ps.setString(5, curso.getEstado());
            ps.setInt(6, curso.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar curso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cursos WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar curso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}