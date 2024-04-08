/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ConexionBD;
import dao.FincaDAO;
import dao.PropietarioDAO;
import modelo.Finca;
import modelo.Propietario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorFinca", urlPatterns = {"/finca"})
public class ControladorFinca extends HttpServlet {

    private FincaDAO fincaDAO;
    private PropietarioDAO propietarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        fincaDAO = new FincaDAO(ConexionBD.getConnection());
        propietarioDAO = new PropietarioDAO(ConexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "agregar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarFincas(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarFinca(request, response);
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
                case "agregar":
                    agregarFinca(request, response);
                    break;
                case "editar":
                    editarFinca(request, response);
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
        List<Propietario> propietarios = propietarioDAO.listarPropietarios();
        request.setAttribute("propietarios", propietarios);
        request.getRequestDispatcher("/vistas/finca/agregar.jsp").forward(request, response);
    }

    private void agregarFinca(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Finca finca = extraerDatosFinca(request);
        boolean agregado = fincaDAO.agregarFinca(finca);
        if (agregado) { 
            request.setAttribute("mensaje", "Finca agregada exitosamente");
            listarFincas(request, response);
        } else {
            mostrarError(request, response, "Error al agregar la finca");
        }
    }

    private Finca extraerDatosFinca(HttpServletRequest request) throws ServletException, IOException {
        // Tu código para extraer datos de la solicitud y crear un objeto Finca
        return null;
        // Tu código para extraer datos de la solicitud y crear un objeto Finca
    }

    private void editarFinca(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Finca finca = extraerDatosFinca(request);
        boolean editado = fincaDAO.editarFinca(finca);
        if (editado) {
            listarFincas(request, response);
        } else {
            mostrarError(request, response, "Error al editar la finca");
        }
    }

    private void eliminarFinca(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = fincaDAO.eliminarFinca(id);
        if (eliminado) {
            listarFincas(request, response);
        } else {
            mostrarError(request, response, "Error al eliminar la finca");
        }
    }

    private void listarFincas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Finca> fincas = fincaDAO.listarFincas();
        request.setAttribute("fincas", fincas);
        request.getRequestDispatcher("vistas/finca/listar.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Finca finca = fincaDAO.obtenerFincaPorId(id);
        List<Propietario> propietarios = propietarioDAO.listarPropietarios();
        request.setAttribute("finca", finca);
        request.setAttribute("propietarios", propietarios);
        request.getRequestDispatcher("vistas/finca/editar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        // Redirige a una página de error o realiza alguna otra acción apropiada
    }
}
