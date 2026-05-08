<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>

<%
    Map<Integer, String> mapaEstudiantes = (Map<Integer, String>) request.getAttribute("mapaEstudiantes");
    Map<Integer, String> mapaCursos = (Map<Integer, String>) request.getAttribute("mapaCursos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva Inscripción</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Onest:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formularios.css">
</head>
<body>
    <div class="contenedor">
        <h1>Nueva Inscripción</h1>
        <p class="subtitulo">
            Selecciona el estudiante, el curso y completa la información de la inscripción.
        </p>

        <form action="${pageContext.request.contextPath}/inscripcion" method="post">
            <div class="fila">
                <div class="grupo-form">
                    <label for="idEstudiante">Estudiante</label>
                    <select name="idEstudiante" id="idEstudiante" required>
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
                    </select>
                </div>

                <div class="grupo-form">
                    <label for="idCurso">Curso</label>
                    <select name="idCurso" id="idCurso" required>
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
                    </select>
                </div>
            </div>

            <div class="grupo-form">
                <label for="estado">Estado</label>
                <select name="estado" id="estado" required>
                    <option value="ACTIVA">ACTIVA</option>
                    <option value="CANCELADA">CANCELADA</option>
                </select>
            </div>

            <div class="grupo-form">
                <label for="observacion">Observación</label>
                <input type="text" id="observacion" name="observacion" placeholder="Escribe una observación si aplica">
            </div>

            <div class="acciones">
                <button type="submit" class="btn btn-guardar">Guardar</button>
                <a href="${pageContext.request.contextPath}/inscripcion?accion=listar" class="btn btn-cancelar">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>