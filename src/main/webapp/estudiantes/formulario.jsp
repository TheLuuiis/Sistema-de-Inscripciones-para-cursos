<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Estudiante" %>

<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
    boolean editando = estudiante != null;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar Estudiante" : "Nuevo Estudiante" %></title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
    <div class="contenedor">
        <h1><%= editando ? "Editar Estudiante" : "Nuevo Estudiante" %></h1>

        <form action="${pageContext.request.contextPath}/estudiante" method="post">
            <% if (editando) { %>
                <input type="hidden" name="id" value="<%= estudiante.getId() %>">
            <% } %>

            <label>Nombre:</label><br>
            <input type="text" name="nombre" value="<%= editando ? estudiante.getNombre() : "" %>" required><br><br>

            <label>Apellido:</label><br>
            <input type="text" name="apellido" value="<%= editando ? estudiante.getApellido() : "" %>" required><br><br>

            <label>Correo:</label><br>
            <input type="email" name="correo" value="<%= editando ? estudiante.getCorreo() : "" %>" required><br><br>

            <label>Teléfono:</label><br>
            <input type="text" name="telefono" value="<%= editando ? estudiante.getTelefono() : "" %>" required><br><br>

            <label>Documento:</label><br>
            <input type="text" name="documento" value="<%= editando ? estudiante.getDocumento() : "" %>" required><br><br>

            <button type="submit">Guardar</button>
            <a href="${pageContext.request.contextPath}/estudiante?accion=listar">Cancelar</a>
        </form>
    </div>
</body>
</html>