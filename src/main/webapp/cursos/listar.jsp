<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Curso" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Cursos</title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
    <div class="contenedor">
        <h1>Cursos</h1>

       <a href="${pageContext.request.contextPath}/curso?accion=nuevo">Nuevo Curso</a>
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
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Cupo Máximo</th>
                <th>Fecha Inicio</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>

            <%
                List<Curso> lista = (List<Curso>) request.getAttribute("listaCursos");
                if (lista != null) {
                    for (Curso c : lista) {
            %>
            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getNombre() %></td>
                <td><%= c.getDescripcion() %></td>
                <td><%= c.getCupoMaximo() %></td>
                <td><%= c.getFechaInicio() %></td>
                <td><%= c.getEstado() %></td>
                <td>
                    <a href="../curso?accion=editar&id=<%= c.getId() %>">Editar</a>
                    |
                    <a href="../curso?accion=eliminar&id=<%= c.getId() %>"
                       onclick="return confirm('¿Desea eliminar este curso?')">Eliminar</a>
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