<%-- 
    Document   : editar
    Created on : 6/04/2024, 9:06:43 p. m.
    Author     : barri
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Finca</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        form {
            text-align: left;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"],
        .btn-back {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
        }
        input[type="submit"]:hover,
        .btn-back:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Editar Finca</h1>
        <form action="finca" method="post">
            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= request.getAttribute("nombre") %>" required><br>
            <label for="numHectareas">Número de Hectáreas:</label>
            <input type="number" id="numHectareas" name="numHectareas" value="<%= request.getAttribute("numHectareas") %>" required><br>
            <label for="metrosCuadrados">Metros Cuadrados:</label>
            <input type="number" id="metrosCuadrados" name="metrosCuadrados" required><br>
            <label for="propietario">Propietario:</label>
            <input type="text" id="propietario" name="propietario" required><br>
            <label for="capataz">Capataz:</label>
            <input type="text" id="capataz" name="capataz" required><br>
            <label for="pais">País:</label>
            <input type="text" id="pais" name="pais" required><br>
            <label for="departamento">Departamento:</label>
            <input type="text" id="departamento" name="departamento" required><br>
            <label for="ciudad">Ciudad:</label>
            <input type="text" id="ciudad" name="ciudad" required><br>
            <label for="si_produce_leche">Si produce Leche:</label>
            <input type="text" id="si_produce_leche" name="si_produce_leche" required><br>
            <label for="si_produce_cereales">Si produce Cereales:</label>
            <input type="text" id="si_produce_cereales" name="si_produce_cereales" required><br>
            <label for="si_produce_frutas">Si produce Frutas:</label>
            <input type="text" id="si_produce_frutas" name="si_produce_frutas" required><br>
            <label for="si_produce_verdura">Si produce Verdura:</label>
            <input type="text" id="si_produce_verdura" name="si_produce_verdura" required><br>
            <label for="Propietario_id">Propietario_id:</label>
            <input type="text" id="Propietario_id" name="Propietario_id" required><br>
            <input type="hidden" name="accion" value="editar">
            <input type="submit" value="Guardar Cambios">
        </form>
        <form action="index.jsp">
            <input type="submit" class="btn-back" value="Volver">
        </form>
        <div class="error-message">
            <% 
                String error = (String) request.getAttribute("error");
                if (error != null) {
                    out.print(error);
                }
            %>
        </div>
    </div>
</body>
</html>
