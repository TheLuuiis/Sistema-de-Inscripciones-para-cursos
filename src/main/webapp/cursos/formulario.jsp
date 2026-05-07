<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Curso" %>

<%
    Curso curso = (Curso) request.getAttribute("curso");
    boolean editando = curso != null;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= editando ? "Editar Curso" : "Nuevo Curso" %></title>
    <link rel="stylesheet" href="../css/estilos.css">
</head>
<body>
    <div class="contenedor">
        <h1><%= editando ? "Editar Curso" : "Nuevo Curso" %></h1>

        <form action="${pageContext.request.contextPath}/curso" method="post">
            <% if (editando) { %>
                <input type="hidden" name="id" value="<%= curso.getId() %>">
            <% } %>

            <label>Nombre:</label><br>
            <input type="text" name="nombre" value="<%= editando ? curso.getNombre() : "" %>" required><br><br>

            <label>Descripción:</label><br>
            <input type="text" name="descripcion" value="<%= editando ? curso.getDescripcion() : "" %>" required><br><br>

            <label>Cupo Máximo:</label><br>
            <input type="number" name="cupoMaximo" value="<%= editando ? curso.getCupoMaximo() : "" %>" required><br><br>

            <label>Fecha de Inicio:</label><br>
            <input type="date" name="fechaInicio" value="<%= editando ? curso.getFechaInicio() : "" %>" required><br><br>

            <label>Estado:</label><br>
            <select name="estado" required>
                <option value="ACTIVO" <%= editando && "ACTIVO".equals(curso.getEstado()) ? "selected" : "" %>>ACTIVO</option>
                <option value="INACTIVO" <%= editando && "INACTIVO".equals(curso.getEstado()) ? "selected" : "" %>>INACTIVO</option>
                <option value="FINALIZADO" <%= editando && "FINALIZADO".equals(curso.getEstado()) ? "selected" : "" %>>FINALIZADO</option>
            </select><br><br>

            <button type="submit">Guardar</button>
            <a href="${pageContext.request.contextPath}/curso?accion=listar">Cancelar</a>
        </form>
    </div>
</body>
</html>