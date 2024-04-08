<%-- 
    Document   : agregar
    Created on : 6/04/2024, 9:06:58?p.?m.
    Author     : barri
--%>

<%@page import="modelo.Propietario"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Finca</title>
</head>
<body>

<h2>Agregar Finca</h2>

<c:if test="${not empty mensaje}">
    <p style="color: green;">${mensaje}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="finca" method="post">
    <input type="hidden" name="accion" value="agregar">
    Nombre: <input type="text" name="nombre" required><br>
    Número de Hectáreas: <input type="number" name="numHectareas" required><br>
    Metros Cuadrados: <input type="number" name="metrosCuadrados" required><br>
    Propietario: <input type="text" name="propietario" required><br>
    Capataz: <input type="text" name="capataz" required><br>
    País: <input type="text" name="pais" required><br>
    Departamento: <input type="text" name="departamento" required><br>
    Ciudad: <input type="text" name="ciudad" required><br>
    ¿Produce Leche? <input type="checkbox" name="siProduceLeche"><br>
    ¿Produce Cereales? <input type="checkbox" name="siProduceCereales"><br>
    ¿Produce Frutas? <input type="checkbox" name="siProduceFrutas"><br>
    ¿Produce Verduras? <input type="checkbox" name="siProduceVerduras"><br>
    <button type="submit">Agregar Finca</button>
</form>

<a href="finca?accion=listar">Volver a la lista de fincas</a>

</body>
</html>
