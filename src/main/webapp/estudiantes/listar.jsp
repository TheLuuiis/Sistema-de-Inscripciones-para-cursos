<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Estudiante" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Estudiantes</title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
    <div class="contenedor">
       <h1>Estudiantes</h1>

       <a href="${pageContext.request.contextPath}/estudiante?accion=nuevo">Nuevo Estudiante</a>
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
                <th>Apellido</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Documento</th>
                <th>Acciones</th>
            </tr>

            <%
                List<Estudiante> lista = (List<Estudiante>) request.getAttribute("listaEstudiantes");
                if (lista != null) {
                    for (Estudiante e : lista) {
            %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getNombre() %></td>
                <td><%= e.getApellido() %></td>
                <td><%= e.getCorreo() %></td>
                <td><%= e.getTelefono() %></td>
                <td><%= e.getDocumento() %></td>
                <td>
                <a href="${pageContext.request.contextPath}/estudiante?accion=editar&id=<%= e.getId() %>">Editar</a>
                <a href="${pageContext.request.contextPath}/estudiante?accion=eliminar&id=<%= e.getId() %>">Eliminar</a>
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