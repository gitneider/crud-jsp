/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ConexionBD;
import dao.PropietarioDAO;
import modelo.Propietario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorPropietario", urlPatterns = {"/propietario"})
public class ControladorPropietario extends HttpServlet {

    private final PropietarioDAO propietarioDAO;

    public ControladorPropietario() {
        super();
        propietarioDAO = new PropietarioDAO(ConexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarPropietarios(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarPropietario(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    registrarPropietario(request, response);
                    break;
                case "editar":
                    editarPropietario(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/vistas/propietario/registrar.jsp").forward(request, response);
    }


    private void registrarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");

        // Validar campos (puedes agregar tus propias validaciones)

        try {
            java.util.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
            Propietario propietario = new Propietario(0, clave, nombre, apellido, fechaNacimiento, email, genero, telefono);
            boolean registrado = propietarioDAO.registrarPropietario(propietario);

            if (registrado) {
                request.setAttribute("mensaje", "Propietario registrado correctamente");
                request.getRequestDispatcher("/vistas/propietario/registrar.jsp").forward(request, response);
            } else {
                mostrarError(request, response, "Error al registrar el propietario");
            }
        } catch (IllegalArgumentException ex) {
            mostrarError(request, response, "Fecha de nacimiento no válida");
        }
    }

    private void editarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");

        // Validar campos (puedes agregar tus propias validaciones)

        try {
            java.util.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
            Propietario propietario = new Propietario(id, clave, nombre, apellido, fechaNacimiento, email, genero, telefono);
            boolean editado = propietarioDAO.editarPropietario(propietario);

            if (editado) {
                response.sendRedirect("propietario?accion=listar");
            } else {
                mostrarError(request, response, "Error al editar el propietario");
            }
        } catch (IllegalArgumentException ex) {
            mostrarError(request, response, "Fecha de nacimiento no válida");
        }
    }

    private void eliminarPropietario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = propietarioDAO.eliminarPropietario(id);

        if (eliminado) {
            response.sendRedirect("propietario?accion=listar");
        } else {
            mostrarError(request, response, "Error al eliminar el propietario");
        }
    }

    private void listarPropietarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Propietario> propietarios = propietarioDAO.listarPropietarios();
        request.setAttribute("propietarios", propietarios);
        request.getRequestDispatcher("/vistas/propietario/listar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("/vistas/error.jsp").forward(request, response);
    }
    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
     Propietario propietario = propietarioDAO.obtenerPropietarioPorId(id);
     request.setAttribute("id", propietario.getId());
     request.setAttribute("clave", propietario.getClave());
     request.setAttribute("nombre", propietario.getNombre());
     request.setAttribute("apellido", propietario.getApellido());
     request.setAttribute("fechaNacimiento", propietario.getFechaNacimiento());
     request.setAttribute("email", propietario.getEmail());
     request.setAttribute("genero", propietario.getGenero());
     request.setAttribute("telefono", propietario.getTelefono());
     request.getRequestDispatcher("vistas/propietario/editar.jsp").forward(request, response);
    }
}
