<%-- 
    Document   : index
    Created on : 6/04/2024, 9:05:22 p. m.
    Author     : barri
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a tu Aplicación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registar los Propietarios</h1>
       
        <a href="propietario?accion=registrar" class="btn">Registrar Nuevo Propietario</a>
        <a href="propietario?accion=listar" class="btn">Listar Propietarios</a>
         <h1>Agregar las Fincas</h1>
        <p>agregar las fincas de los propietarios.</p>
        <a href="finca?accion=agregar" class="btn">Agregar Nuevas Fincas</a>
        <a href="finca?accion=listar" class="btn">Listar Fincas</a>
    </div>
</body>
</html>