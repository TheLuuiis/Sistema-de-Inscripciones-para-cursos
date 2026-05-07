package com.proyecto.sistemainscripciones.servlets;

import com.proyecto.sistemainscripciones.modelos.Estudiante;
import com.proyecto.sistemainscripciones.servicios.EstudianteServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/estudiante")
public class EstudianteServlet extends HttpServlet {

    private final EstudianteServicio estudianteServicio = new EstudianteServicio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            request.setAttribute("listaEstudiantes", estudianteServicio.listarEstudiantes());
            request.getRequestDispatcher("/estudiantes/listar.jsp").forward(request, response);

        } else if (accion.equals("nuevo")) {
            request.getRequestDispatcher("/estudiantes/formulario.jsp").forward(request, response);

        } else if (accion.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Estudiante estudiante = estudianteServicio.obtenerEstudiantePorId(id);
            request.setAttribute("estudiante", estudiante);
            request.getRequestDispatcher("/estudiantes/formulario.jsp").forward(request, response);

        } else if (accion.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            estudianteServicio.eliminarEstudiante(id);
            response.sendRedirect(request.getContextPath() + "/estudiante?accion=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String documento = request.getParameter("documento");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCorreo(correo);
        estudiante.setTelefono(telefono);
        estudiante.setDocumento(documento);

        String mensaje;

        if (idStr == null || idStr.isEmpty()) {
            mensaje = estudianteServicio.guardarEstudiante(estudiante);
        } else {
            estudiante.setId(Integer.parseInt(idStr));
            mensaje = estudianteServicio.actualizarEstudiante(estudiante);
        }

        request.getSession().setAttribute("mensaje", mensaje);
        response.sendRedirect(request.getContextPath() + "/estudiante?accion=listar");
    }
}