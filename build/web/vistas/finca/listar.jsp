<%-- 
    Document   : listar
    Created on : 6/04/2024, 9:07:07 p. m.
    Author     : barri
--%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Fincas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
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
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn-back {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn-back:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Listado de Fincas</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Número de Hectáreas</th>
                    <th>Metros Cuadrados</th>
                    <th>Propietario</th>
                    <th>Capataz</th>
                    <th>País</th>
                    <th>Departamento</th>
                    <th>Ciudad</th>
                    <th>Produce Leche</th>
                    <th>Produce Cereales</th>
                    <th>Produce Frutas</th>
                    <th>Produce Verduras</th>
                    <th>ID Propietario</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<modelo.Finca> fincas = (List<modelo.Finca>) request.getAttribute("fincas");
                    for (modelo.Finca finca : fincas) {
                %>
                <tr>
                    <td><%= finca.getNombre() %></td>
                    <td><%= finca.getNumHectareas() %></td>
                    <td><%= finca.getMetrosCuadrados() %></td>
                    <td><%= finca.getPropietario() %></td>
                    <td><%= finca.getCapataz() %></td>
                    <td><%= finca.getPais() %></td>
                    <td><%= finca.getDepartamento() %></td>
                    <td><%= finca.getCiudad() %></td>
                    <td><%= finca.isSiProduceLeche() %></td>
                    <td><%= finca.isSiProduceCereales() %></td>
                    <td><%= finca.isSiProduceFrutas() %></td>
                    <td><%= finca.isSiProduceVerduras() %></td>
                    <td><%= finca.getPropietarioId() %></td>
                    <td>
                        <a href="finca?accion=editar&id=<%= finca.getNombre() %>" class="btn-edit">Editar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <form action="index.jsp">
            <input type="submit" class="btn-back" value="Ir a Inicio">
        </form>
    </div>
</body>
</html>
