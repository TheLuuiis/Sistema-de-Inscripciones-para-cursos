package com.proyecto.sistemainscripciones.servicios;

import com.proyecto.sistemainscripciones.dao.EstudianteDAO;
import com.proyecto.sistemainscripciones.modelos.Estudiante;
import com.proyecto.sistemainscripciones.utils.Validador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudianteServicio {

    private final EstudianteDAO estudianteDAO = new EstudianteDAO();

    public String guardarEstudiante(Estudiante estudiante) {
        if (!Validador.esTextoValido(estudiante.getNombre())) {
            return "El nombre del estudiante es obligatorio.";
        }

        if (!Validador.esTextoValido(estudiante.getApellido())) {
            return "El apellido del estudiante es obligatorio.";
        }

        if (!Validador.esCorreoValido(estudiante.getCorreo())) {
            return "El correo electrónico no es válido.";
        }

        if (!Validador.esTelefonoValido(estudiante.getTelefono())) {
            return "El teléfono debe contener entre 7 y 15 dígitos.";
        }

        if (!Validador.esDocumentoValido(estudiante.getDocumento())) {
            return "El documento debe contener entre 5 y 20 dígitos.";
        }

        boolean guardado = estudianteDAO.insertar(estudiante);
        return guardado ? "Estudiante guardado correctamente." : "No se pudo guardar el estudiante.";
    }

    public String actualizarEstudiante(Estudiante estudiante) {
        if (estudiante.getId() <= 0) {
            return "El ID del estudiante no es válido.";
        }

        if (!Validador.esTextoValido(estudiante.getNombre())) {
            return "El nombre del estudiante es obligatorio.";
        }

        if (!Validador.esTextoValido(estudiante.getApellido())) {
            return "El apellido del estudiante es obligatorio.";
        }

        if (!Validador.esCorreoValido(estudiante.getCorreo())) {
            return "El correo electrónico no es válido.";
        }

        if (!Validador.esTelefonoValido(estudiante.getTelefono())) {
            return "El teléfono debe contener entre 7 y 15 dígitos.";
        }

        if (!Validador.esDocumentoValido(estudiante.getDocumento())) {
            return "El documento debe contener entre 5 y 20 dígitos.";
        }

        boolean actualizado = estudianteDAO.actualizar(estudiante);
        return actualizado ? "Estudiante actualizado correctamente." : "No se pudo actualizar el estudiante.";
    }

    public String eliminarEstudiante(int id) {
        if (id <= 0) {
            return "El ID del estudiante no es válido.";
        }

        boolean eliminado = estudianteDAO.eliminar(id);
        return eliminado ? "Estudiante eliminado correctamente." : "No se pudo eliminar el estudiante.";
    }

    public List<Estudiante> listarEstudiantes() {
        return new ArrayList<>(estudianteDAO.listarTodos());
    }

    public Estudiante obtenerEstudiantePorId(int id) {
        if (id <= 0) {
            return null;
        }
        return estudianteDAO.buscarPorId(id);
    }

    public Map<Integer, String> obtenerMapaEstudiantes() {
        List<Estudiante> estudiantes = estudianteDAO.listarTodos();
        Map<Integer, String> mapa = new HashMap<>();

        for (Estudiante e : estudiantes) {
            mapa.put(e.getId(), e.getNombre() + " " + e.getApellido());
        }

        return mapa;
    }
}