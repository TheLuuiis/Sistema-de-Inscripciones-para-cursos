<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Inscripcion" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Inscripciones</title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Onest:wght@100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/listar.css">
</head>
<body>
    <div class="contenedor">
        <div class="encabezado-lista">
            <div>
                <span class="badge">Gestión académica</span>
                <h1>Inscripciones</h1>
                <p class="subtitulo">
                    Administra las inscripciones realizadas por los estudiantes en los cursos disponibles.
                </p>
            </div>

            <div class="acciones-superiores">
                <a href="${pageContext.request.contextPath}/inscripcion?accion=nuevo" class="btn btn-principal">Nueva Inscripción</a>
                <a href="${pageContext.request.contextPath}/index.html" class="btn btn-secundario">Volver al Inicio</a>
            </div>
        </div>

        <%
            String mensaje = (String) session.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <div class="alerta-exito">
                <strong><%= mensaje %></strong>
            </div>
        <%
                session.removeAttribute("mensaje");
            }
        %>

        <div class="tabla-contenedor">
            <table class="tabla-datos">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ID Estudiante</th>
                        <th>ID Curso</th>
                        <th>Fecha</th>
                        <th>Estado</th>
                        <th>Observación</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Inscripcion> lista = (List<Inscripcion>) request.getAttribute("listaInscripciones");
                        if (lista != null && !lista.isEmpty()) {
                            for (Inscripcion i : lista) {
                    %>
                    <tr>
                        <td><%= i.getId() %></td>
                        <td><%= i.getIdEstudiante() %></td>
                        <td><%= i.getIdCurso() %></td>
                        <td><%= i.getFechaInscripcion() %></td>
                        <td>
                            <span class="estado estado-<%= i.getEstado().toLowerCase() %>">
                                <%= i.getEstado() %>
                            </span>
                        </td>
                        <td><%= i.getObservacion() != null ? i.getObservacion() : "" %></td>
                        <td>
                            <div class="acciones-tabla">
                                <a href="${pageContext.request.contextPath}/inscripcion?accion=eliminar&id=<%= i.getId() %>"
                                   class="btn-tabla eliminar"
                                   onclick="return confirm('¿Desea eliminar esta inscripción?')">Eliminar</a>
                            </div>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7" class="sin-datos">No hay inscripciones registradas actualmente.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>