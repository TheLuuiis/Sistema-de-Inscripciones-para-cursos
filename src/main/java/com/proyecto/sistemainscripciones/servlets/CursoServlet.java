package com.proyecto.sistemainscripciones.servlets;

import com.proyecto.sistemainscripciones.modelos.Curso;
import com.proyecto.sistemainscripciones.servicios.CursoServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/curso")
public class CursoServlet extends HttpServlet {

    private final CursoServicio cursoServicio = new CursoServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("listaCursos", cursoServicio.listarCursos());
            request.getRequestDispatcher("/cursos/listar.jsp").forward(request, response);

        } else if (accion.equals("nuevo")) {
            request.getRequestDispatcher("/cursos/formulario.jsp").forward(request, response);

        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Curso curso = cursoServicio.obtenerCursoPorId(id);
            request.setAttribute("curso", curso);
            request.getRequestDispatcher("/cursos/formulario.jsp").forward(request, response);

        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            cursoServicio.eliminarCurso(id);
            response.sendRedirect(request.getContextPath() + "/curso?accion=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
        String fechaInicio = request.getParameter("fechaInicio");
        String estado = request.getParameter("estado");

        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setCupoMaximo(cupoMaximo);
        curso.setFechaInicio(fechaInicio);
        curso.setEstado(estado);

        String mensaje;

        if (idStr == null || idStr.isEmpty()) {
            mensaje = cursoServicio.guardarCurso(curso);
        } else {
            curso.setId(Integer.parseInt(idStr));
            mensaje = cursoServicio.actualizarCurso(curso);
        }

        request.getSession().setAttribute("mensaje", mensaje);
        response.sendRedirect(request.getContextPath() + "/curso?accion=listar");
    }
}