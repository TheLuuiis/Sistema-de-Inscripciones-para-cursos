<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Curso" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Cursos</title>

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
                <h1>Cursos</h1>
                <p class="subtitulo">Consulta, registra, edita o elimina los cursos disponibles en el sistema.</p>
            </div>

            <div class="acciones-superiores">
                <a href="${pageContext.request.contextPath}/curso?accion=nuevo" class="btn btn-principal">Nuevo Curso</a>
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
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Cupo Máximo</th>
                        <th>Fecha Inicio</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Curso> lista = (List<Curso>) request.getAttribute("listaCursos");
                        if (lista != null && !lista.isEmpty()) {
                            for (Curso c : lista) {
                    %>
                    <tr>
                        <td><%= c.getId() %></td>
                        <td><%= c.getNombre() %></td>
                        <td><%= c.getDescripcion() %></td>
                        <td><%= c.getCupoMaximo() %></td>
                        <td><%= c.getFechaInicio() %></td>
                        <td>
                            <span class="estado estado-<%= c.getEstado().toLowerCase() %>">
                                <%= c.getEstado() %>
                            </span>
                        </td>
                        <td>
                            <div class="acciones-tabla">
                                <a href="${pageContext.request.contextPath}/curso?accion=editar&id=<%= c.getId() %>" class="btn-tabla editar">Editar</a>
                                <a href="${pageContext.request.contextPath}/curso?accion=eliminar&id=<%= c.getId() %>"
                                   class="btn-tabla eliminar"
                                   onclick="return confirm('¿Desea eliminar este curso?')">Eliminar</a>
                            </div>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7" class="sin-datos">No hay cursos registrados actualmente.</td>
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