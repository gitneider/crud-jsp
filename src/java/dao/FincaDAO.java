/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Finca;

public class FincaDAO {

    private final Connection conexion;

    public FincaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregarFinca(Finca finca) {
        String sql = "INSERT INTO fincas (nombre, num_hectareas, metros_cuadrados, propietario, capataz, pais, "
                + "departamento, ciudad, si_produce_leche, si_produce_cereales, "
                + "si_produce_frutas, si_produce_verduras, propietario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, finca.getNombre());
            statement.setString(2, finca.getNumHectareas());
            statement.setString(3, finca.getMetrosCuadrados());
            statement.setString(4, finca.getPropietario());
            statement.setString(5, finca.getCapataz());
            statement.setString(6, finca.getPais());
            statement.setString(7, finca.getDepartamento());
            statement.setString(8, finca.getCiudad());
            statement.setString(9, finca.getSiProduceLeche());
            statement.setString(10, finca.getSiProduceCereales());
            statement.setString(11, finca.getSiProduceFrutas());
            statement.setString(12, finca.getSiProduceVerduras());
            statement.setString(13, finca.getPropietarioId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editarFinca(Finca finca) {
        String sql = "UPDATE fincas SET nombre=?, num_hectareas=?, metros_cuadrados=?, propietario=?, "
                + "capataz=?, pais=?, "
                + "departamento=?, ciudad=?, si_produce_leche=?, si_produce_cereales=?, si_produce_frutas=?, si_produce_verduras=?, propietario_id=? WHERE id=?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, finca.getNombre());
            statement.setString(2, finca.getNumHectareas());
            statement.setString(3, finca.getMetrosCuadrados());
            statement.setString(4, finca.getPropietario());
            statement.setString(5, finca.getCapataz());
            statement.setString(6, finca.getPais());
            statement.setString(7, finca.getDepartamento());
            statement.setString(8, finca.getCiudad());
            statement.setString(9, finca.getSiProduceLeche());
            statement.setString(10, finca.getSiProduceCereales());
            statement.setString(11, finca.getSiProduceFrutas());
            statement.setString(12, finca.getSiProduceVerduras());
            statement.setString(13, finca.getPropietarioId());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarFinca(int id) {
        String sql = "DELETE FROM fincas WHERE id=?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Finca> listarFincas() {
        List<Finca> listaFincas = new ArrayList<>();
        String sql = "SELECT * FROM fincas";
        try (PreparedStatement statement = conexion.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Finca finca = new Finca();
                finca.setId(resultSet.getInt("id"));
                finca.setNombre(resultSet.getString("nombre"));
                finca.setNumHectareas(resultSet.getString("num_hectareas"));
                finca.setMetrosCuadrados(resultSet.getString("metros_cuadrados"));
                finca.setPropietario(resultSet.getString("propietario"));
                finca.setCapataz(resultSet.getString("capataz"));
                finca.setPais(resultSet.getString("pais"));
                finca.setDepartamento(resultSet.getString("departamento"));
                finca.setCiudad(resultSet.getString("ciudad"));
                finca.setSiProduceLeche(resultSet.getString("si_produce_leche"));
                finca.setSiProduceCereales(resultSet.getString("si_produce_cereales"));
                finca.setSiProduceFrutas(resultSet.getString("si_produce_frutas"));
                finca.setSiProduceVerduras(resultSet.getString("si_produce_verduras"));
                finca.setPropietarioId(resultSet.getString("propietario_id"));
                listaFincas.add(finca);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaFincas;
    }

    public Finca obtenerFincaPorId(int id) {
        String sql = "SELECT * FROM fincas WHERE id=?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Finca finca = new Finca();
                    finca.setId(resultSet.getInt("id"));
                    finca.setNombre(resultSet.getString("nombre"));
                    finca.setNumHectareas(resultSet.getString("num_hectareas"));
                    finca.setMetrosCuadrados(resultSet.getString("metros_cuadrados"));
                    finca.setPropietario(resultSet.getString("propietario"));
                    finca.setCapataz(resultSet.getString("capataz"));
                    finca.setPais(resultSet.getString("pais"));
                    finca.setDepartamento(resultSet.getString("departamento"));
                    finca.setCiudad(resultSet.getString("ciudad"));
                    finca.setSiProduceLeche(resultSet.getString("si_produce_leche"));
                    finca.setSiProduceCereales(resultSet.getString("si_produce_cereales"));
                    finca.setSiProduceFrutas(resultSet.getString("si_produce_frutas"));
                    finca.setSiProduceVerduras(resultSet.getString("si_produce_verduras"));
                    finca.setPropietarioId(resultSet.getString("propietario_id"));
                    return finca;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
