package com.proyecto.sistemainscripciones.dao;

import com.proyecto.sistemainscripciones.modelos.Inscripcion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {

    public boolean insertar(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripciones (id_estudiante, id_curso, estado, observacion) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, inscripcion.getIdEstudiante());
            ps.setInt(2, inscripcion.getIdCurso());
            ps.setString(3, inscripcion.getEstado());
            ps.setString(4, inscripcion.getObservacion());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar inscripción: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Inscripcion> listarTodas() {
        List<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT * FROM inscripciones ORDER BY id";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setId(rs.getInt("id"));
                i.setIdEstudiante(rs.getInt("id_estudiante"));
                i.setIdCurso(rs.getInt("id_curso"));
                i.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                i.setEstado(rs.getString("estado"));
                i.setObservacion(rs.getString("observacion"));
                lista.add(i);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar inscripciones: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    public Inscripcion buscarPorId(int id) {
        String sql = "SELECT * FROM inscripciones WHERE id = ?";
        Inscripcion i = null;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    i = new Inscripcion();
                    i.setId(rs.getInt("id"));
                    i.setIdEstudiante(rs.getInt("id_estudiante"));
                    i.setIdCurso(rs.getInt("id_curso"));
                    i.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                    i.setEstado(rs.getString("estado"));
                    i.setObservacion(rs.getString("observacion"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar inscripción: " + e.getMessage());
            e.printStackTrace();
        }

        return i;
    }

    public boolean actualizarEstado(int id, String estado) {
        String sql = "UPDATE inscripciones SET estado = ? WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar estado de inscripción: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM inscripciones WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar inscripción: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}