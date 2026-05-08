<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proyecto.sistemainscripciones.modelos.Estudiante" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Estudiantes</title>

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
                <h1>Estudiantes</h1>
                <p class="subtitulo">
                    Consulta, registra, edita o elimina los estudiantes registrados en el sistema.
                </p>
            </div>

            <div class="acciones-superiores">
                <a href="${pageContext.request.contextPath}/estudiante?accion=nuevo" class="btn btn-principal">Nuevo Estudiante</a>
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
                        <th>Apellido</th>
                        <th>Correo</th>
                        <th>Teléfono</th>
                        <th>Documento</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Estudiante> lista = (List<Estudiante>) request.getAttribute("listaEstudiantes");
                        if (lista != null && !lista.isEmpty()) {
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
                            <div class="acciones-tabla">
                                <a href="${pageContext.request.contextPath}/estudiante?accion=editar&id=<%= e.getId() %>" class="btn-tabla editar">Editar</a>
                                <a href="${pageContext.request.contextPath}/estudiante?accion=eliminar&id=<%= e.getId() %>"
                                   class="btn-tabla eliminar"
                                   onclick="return confirm('¿Desea eliminar este estudiante?')">Eliminar</a>
                            </div>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7" class="sin-datos">No hay estudiantes registrados actualmente.</td>
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