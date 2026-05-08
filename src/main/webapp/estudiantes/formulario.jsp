<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Estudiante" %>

<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
    boolean editando = estudiante != null;
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= editando ? "Editar Estudiante" : "Nuevo Estudiante" %></title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Onest:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formularios.css">
</head>
<body>
    <div class="contenedor">
        <h1><%= editando ? "Editar Estudiante" : "Nuevo Estudiante" %></h1>
        <p class="subtitulo">
            <%= editando ? "Modifica los datos del estudiante seleccionado." : "Completa la información para registrar un nuevo estudiante." %>
        </p>

        <form action="${pageContext.request.contextPath}/estudiante" method="post">
            <% if (editando) { %>
                <input type="hidden" name="id" value="<%= estudiante.getId() %>">
            <% } %>

            <div class="fila">
                <div class="grupo-form">
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" name="nombre" value="<%= editando ? estudiante.getNombre() : "" %>" required>
                </div>

                <div class="grupo-form">
                    <label for="apellido">Apellido</label>
                    <input type="text" id="apellido" name="apellido" value="<%= editando ? estudiante.getApellido() : "" %>" required>
                </div>
            </div>

            <div class="grupo-form">
                <label for="correo">Correo</label>
                <input type="email" id="correo" name="correo" value="<%= editando ? estudiante.getCorreo() : "" %>" required>
            </div>

            <div class="fila">
                <div class="grupo-form">
                    <label for="telefono">Teléfono</label>
                    <input type="text" id="telefono" name="telefono" value="<%= editando ? estudiante.getTelefono() : "" %>" required>
                </div>

                <div class="grupo-form">
                    <label for="documento">Documento</label>
                    <input type="text" id="documento" name="documento" value="<%= editando ? estudiante.getDocumento() : "" %>" required>
                </div>
            </div>

            <div class="acciones">
                <button type="submit" class="btn btn-guardar">Guardar</button>
                <a href="${pageContext.request.contextPath}/estudiante?accion=listar" class="btn btn-cancelar">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>