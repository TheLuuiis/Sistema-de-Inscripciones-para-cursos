package com.proyecto.sistemainscripciones.servicios;

import com.proyecto.sistemainscripciones.dao.CursoDAO;
import com.proyecto.sistemainscripciones.dao.InscripcionDAO;
import com.proyecto.sistemainscripciones.modelos.Curso;
import com.proyecto.sistemainscripciones.modelos.Inscripcion;
import com.proyecto.sistemainscripciones.utils.Validador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InscripcionServicio {

    private final InscripcionDAO inscripcionDAO = new InscripcionDAO();
    private final CursoDAO cursoDAO = new CursoDAO();

    public String guardarInscripcion(Inscripcion inscripcion) {
        if (!Validador.esNumeroPositivo(inscripcion.getIdEstudiante())) {
            return "Debe seleccionar un estudiante válido.";
        }

        if (!Validador.esNumeroPositivo(inscripcion.getIdCurso())) {
            return "Debe seleccionar un curso válido.";
        }

        if (!Validador.esTextoValido(inscripcion.getEstado())) {
            return "El estado de la inscripción es obligatorio.";
        }

        if (!"ACTIVA".equals(inscripcion.getEstado()) && !"CANCELADA".equals(inscripcion.getEstado())) {
            return "El estado de la inscripción no es válido.";
        }

        Curso curso = cursoDAO.buscarPorId(inscripcion.getIdCurso());
        if (curso == null) {
            return "El curso seleccionado no existe.";
        }

        boolean guardado = inscripcionDAO.insertar(inscripcion);
        return guardado ? "Inscripción guardada correctamente." : "No se pudo guardar la inscripción.";
    }

    public String actualizarEstadoInscripcion(int id, String estado) {
        if (!Validador.esNumeroPositivo(id)) {
            return "El ID de la inscripción no es válido.";
        }

        if (!Validador.esTextoValido(estado)) {
            return "El estado es obligatorio.";
        }

        if (!"ACTIVA".equals(estado) && !"CANCELADA".equals(estado)) {
            return "El estado de la inscripción no es válido.";
        }

        boolean actualizado = inscripcionDAO.actualizarEstado(id, estado);
        return actualizado ? "Estado de inscripción actualizado correctamente." : "No se pudo actualizar el estado.";
    }

    public String eliminarInscripcion(int id) {
        if (!Validador.esNumeroPositivo(id)) {
            return "El ID de la inscripción no es válido.";
        }

        boolean eliminado = inscripcionDAO.eliminar(id);
        return eliminado ? "Inscripción eliminada correctamente." : "No se pudo eliminar la inscripción.";
    }

    public List<Inscripcion> listarInscripciones() {
        return new ArrayList<>(inscripcionDAO.listarTodas());
    }

    public Inscripcion obtenerInscripcionPorId(int id) {
        if (id <= 0) {
            return null;
        }
        return inscripcionDAO.buscarPorId(id);
    }

    public Map<String, Integer> obtenerResumenPorEstado() {
        List<Inscripcion> inscripciones = inscripcionDAO.listarTodas();
        Map<String, Integer> resumen = new HashMap<>();

        for (Inscripcion i : inscripciones) {
            String estado = i.getEstado();
            resumen.put(estado, resumen.getOrDefault(estado, 0) + 1);
        }

        return resumen;
    }
}