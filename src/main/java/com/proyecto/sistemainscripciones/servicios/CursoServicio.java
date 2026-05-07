package com.proyecto.sistemainscripciones.servicios;

import com.proyecto.sistemainscripciones.dao.CursoDAO;
import com.proyecto.sistemainscripciones.modelos.Curso;
import com.proyecto.sistemainscripciones.utils.Validador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CursoServicio {

    private final CursoDAO cursoDAO = new CursoDAO();

    public String guardarCurso(Curso curso) {
        if (!Validador.esTextoValido(curso.getNombre())) {
            return "El nombre del curso es obligatorio.";
        }

        if (!Validador.esTextoValido(curso.getDescripcion())) {
            return "La descripción del curso es obligatoria.";
        }

        if (!Validador.esNumeroPositivo(curso.getCupoMaximo())) {
            return "El cupo máximo debe ser mayor que cero.";
        }

        if (!Validador.esTextoValido(curso.getFechaInicio())) {
            return "La fecha de inicio es obligatoria.";
        }

        if (!Validador.esTextoValido(curso.getEstado())) {
            return "El estado del curso es obligatorio.";
        }

        if (!"ACTIVO".equals(curso.getEstado())
                && !"INACTIVO".equals(curso.getEstado())
                && !"FINALIZADO".equals(curso.getEstado())) {
            return "El estado del curso no es válido.";
        }

        boolean guardado = cursoDAO.insertar(curso);
        return guardado ? "Curso guardado correctamente." : "No se pudo guardar el curso.";
    }

    public String actualizarCurso(Curso curso) {
        if (curso.getId() <= 0) {
            return "El ID del curso no es válido.";
        }

        if (!Validador.esTextoValido(curso.getNombre())) {
            return "El nombre del curso es obligatorio.";
        }

        if (!Validador.esTextoValido(curso.getDescripcion())) {
            return "La descripción del curso es obligatoria.";
        }

        if (!Validador.esNumeroPositivo(curso.getCupoMaximo())) {
            return "El cupo máximo debe ser mayor que cero.";
        }

        if (!Validador.esTextoValido(curso.getFechaInicio())) {
            return "La fecha de inicio es obligatoria.";
        }

        if (!Validador.esTextoValido(curso.getEstado())) {
            return "El estado del curso es obligatorio.";
        }

        if (!"ACTIVO".equals(curso.getEstado())
                && !"INACTIVO".equals(curso.getEstado())
                && !"FINALIZADO".equals(curso.getEstado())) {
            return "El estado del curso no es válido.";
        }

        boolean actualizado = cursoDAO.actualizar(curso);
        return actualizado ? "Curso actualizado correctamente." : "No se pudo actualizar el curso.";
    }

    public String eliminarCurso(int id) {
        if (id <= 0) {
            return "El ID del curso no es válido.";
        }

        boolean eliminado = cursoDAO.eliminar(id);
        return eliminado ? "Curso eliminado correctamente." : "No se pudo eliminar el curso.";
    }

    public List<Curso> listarCursos() {
        return new ArrayList<>(cursoDAO.listarTodos());
    }

    public Curso obtenerCursoPorId(int id) {
        if (id <= 0) {
            return null;
        }
        return cursoDAO.buscarPorId(id);
    }

    public Map<Integer, String> obtenerMapaCursos() {
        List<Curso> cursos = cursoDAO.listarTodos();
        Map<Integer, String> mapa = new HashMap<>();

        for (Curso c : cursos) {
            mapa.put(c.getId(), c.getNombre());
        }

        return mapa;
    }
}