package com.proyecto.sistemainscripciones.servlets;

import com.proyecto.sistemainscripciones.modelos.Inscripcion;
import com.proyecto.sistemainscripciones.servicios.CursoServicio;
import com.proyecto.sistemainscripciones.servicios.EstudianteServicio;
import com.proyecto.sistemainscripciones.servicios.InscripcionServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/inscripcion")
public class InscripcionServlet extends HttpServlet {

    private final InscripcionServicio inscripcionServicio = new InscripcionServicio();
    private final EstudianteServicio estudianteServicio = new EstudianteServicio();
    private final CursoServicio cursoServicio = new CursoServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("listaInscripciones", inscripcionServicio.listarInscripciones());
            request.getRequestDispatcher("/inscripciones/listar.jsp").forward(request, response);

        } else if (accion.equals("nuevo")) {
            request.setAttribute("mapaEstudiantes", estudianteServicio.obtenerMapaEstudiantes());
            request.setAttribute("mapaCursos", cursoServicio.obtenerMapaCursos());
            request.getRequestDispatcher("/inscripciones/formulario.jsp").forward(request, response);

        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            inscripcionServicio.eliminarInscripcion(id);
            response.sendRedirect(request.getContextPath() + "/inscripcion?accion=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        String estado = request.getParameter("estado");
        String observacion = request.getParameter("observacion");

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setIdEstudiante(idEstudiante);
        inscripcion.setIdCurso(idCurso);
        inscripcion.setEstado(estado);
        inscripcion.setObservacion(observacion);

        String mensaje = inscripcionServicio.guardarInscripcion(inscripcion);

        request.getSession().setAttribute("mensaje", mensaje);
        response.sendRedirect(request.getContextPath() + "/inscripcion?accion=listar");
    }
}