<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Curso" %>

<%
    Curso curso = (Curso) request.getAttribute("curso");
    boolean editando = curso != null;
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= editando ? "Editar Curso" : "Nuevo Curso" %></title>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Onest:wght@100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formularios.css">
</head>
<body>
    <div class="contenedor">
        <h1><%= editando ? "Editar Curso" : "Nuevo Curso" %></h1>
        <p class="subtitulo">
            <%= editando ? "Actualiza la información del curso seleccionado." : "Completa los datos para registrar un nuevo curso." %>
        </p>

        <form action="${pageContext.request.contextPath}/curso" method="post">
            <% if (editando) { %>
                <input type="hidden" name="id" value="<%= curso.getId() %>">
            <% } %>

            <div class="grupo-form">
                <label for="nombre">Nombre del curso</label>
                <input
                    type="text"
                    id="nombre"
                    name="nombre"
                    value="<%= editando ? curso.getNombre() : "" %>"
                    required>
            </div>

            <div class="grupo-form">
                <label for="descripcion">Descripción</label>
                <input
                    type="text"
                    id="descripcion"
                    name="descripcion"
                    value="<%= editando ? curso.getDescripcion() : "" %>"
                    required>
            </div>

            <div class="fila">
                <div class="grupo-form">
                    <label for="cupoMaximo">Cupo máximo</label>
                    <input
                        type="number"
                        id="cupoMaximo"
                        name="cupoMaximo"
                        value="<%= editando ? curso.getCupoMaximo() : "" %>"
                        required>
                </div>

                <div class="grupo-form">
                    <label for="fechaInicio">Fecha de inicio</label>
                    <input
                        type="date"
                        id="fechaInicio"
                        name="fechaInicio"
                        value="<%= editando ? curso.getFechaInicio() : "" %>"
                        required>
                </div>
            </div>

            <div class="grupo-form">
                <label for="estado">Estado</label>
                <select name="estado" id="estado" required>
                    <option value="ACTIVO" <%= editando && "ACTIVO".equals(curso.getEstado()) ? "selected" : "" %>>ACTIVO</option>
                    <option value="INACTIVO" <%= editando && "INACTIVO".equals(curso.getEstado()) ? "selected" : "" %>>INACTIVO</option>
                    <option value="FINALIZADO" <%= editando && "FINALIZADO".equals(curso.getEstado()) ? "selected" : "" %>>FINALIZADO</option>
                </select>
            </div>

            <div class="acciones">
                <button type="submit" class="btn btn-guardar">Guardar</button>
                <a href="${pageContext.request.contextPath}/curso?accion=listar" class="btn btn-cancelar">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>