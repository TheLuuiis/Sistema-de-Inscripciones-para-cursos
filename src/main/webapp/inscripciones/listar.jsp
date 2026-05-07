<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Inscripcion" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Inscripciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="contenedor">
        <h1>Inscripciones</h1>

       <a href="${pageContext.request.contextPath}/inscripcion?accion=nuevo">Nueva Inscripción</a>
       <a href="${pageContext.request.contextPath}/index.html">Volver al Inicio</a>

        <br><br>

        <%
            String mensaje = (String) session.getAttribute("mensaje");
            if (mensaje != null) {
        %>
            <p><strong><%= mensaje %></strong></p>
        <%
                session.removeAttribute("mensaje");
            }
        %>

        <table border="1" width="100%" cellpadding="8">
            <tr>
                <th>ID</th>
                <th>ID Estudiante</th>
                <th>ID Curso</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Observación</th>
                <th>Acciones</th>
            </tr>

            <%
                List<Inscripcion> lista = (List<Inscripcion>) request.getAttribute("listaInscripciones");
                if (lista != null) {
                    for (Inscripcion i : lista) {
            %>
            <tr>
                <td><%= i.getId() %></td>
                <td><%= i.getIdEstudiante() %></td>
                <td><%= i.getIdCurso() %></td>
                <td><%= i.getFechaInscripcion() %></td>
                <td><%= i.getEstado() %></td>
                <td><%= i.getObservacion() %></td>
                <td>
                    <a href="${pageContext.request.contextPath}/inscripcion?accion=eliminar&id=<%= i.getId() %>"
                       onclick="return confirm('¿Desea eliminar esta inscripción?')">Eliminar</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
</body>
</html>