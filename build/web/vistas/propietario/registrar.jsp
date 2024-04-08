<%-- 
    Document   : registrar
    Created on : 6/04/2024, 9:06:22 p. m.
    Author     : barri
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Nuevo Propietario</title>
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
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="date"],
        input[type="email"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        select {
            height: 40px;
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
        <h1>Registrar Nuevo Propietario</h1>
        <form action="propietario" method="post">
            <label for="clave">Clave:</label>
            <input type="text" id="clave" name="clave" required><br>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" required><br>
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            <label for="genero">Género:</label>
            <select id="genero" name="genero" required>
                <option value="">Seleccionar</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
            </select><br>
            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono" required><br>
            <input type="hidden" name="accion" value="registrar">
            <input type="submit" value="Registrar">
        </form>
        <form action="propietario" method="get">
            <input type="hidden" name="accion" value="listar">
            <br>
            <input type="submit" class="btn-back" value="Volver a Listar">
        </form>
        <%-- Sección de Mensaje de Error --%>
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
