<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>

<%
    Map<Integer, String> mapaEstudiantes = (Map<Integer, String>) request.getAttribute("mapaEstudiantes");
    Map<Integer, String> mapaCursos = (Map<Integer, String>) request.getAttribute("mapaCursos");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nueva Inscripción</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>
    <div class="contenedor">
        <h1>Nueva Inscripción</h1>

        <form action="${pageContext.request.contextPath}/inscripcion" method="post">
            <label>Estudiante:</label><br>
            <select name="idEstudiante" required>
                <option value="">Seleccione</option>
                <%
                    if (mapaEstudiantes != null) {
                        for (Map.Entry<Integer, String> entry : mapaEstudiantes.entrySet()) {
                %>
                    <option value="<%= entry.getKey() %>"><%= entry.getValue() %></option>
                <%
                        }
                    }
                %>
            </select><br><br>

            <label>Curso:</label><br>
            <select name="idCurso" required>
                <option value="">Seleccione</option>
                <%
                    if (mapaCursos != null) {
                        for (Map.Entry<Integer, String> entry : mapaCursos.entrySet()) {
                %>
                    <option value="<%= entry.getKey() %>"><%= entry.getValue() %></option>
                <%
                        }
                    }
                %>
            </select><br><br>

            <label>Estado:</label><br>
            <select name="estado" required>
                <option value="ACTIVA">ACTIVA</option>
                <option value="CANCELADA">CANCELADA</option>
            </select><br><br>

            <label>Observación:</label><br>
            <input type="text" name="observacion"><br><br>

            <button type="submit">Guardar</button>
            <a href="${pageContext.request.contextPath}/inscripcion?accion=listar">Cancelar</a>
        </form>
    </div>
</body>
</html>