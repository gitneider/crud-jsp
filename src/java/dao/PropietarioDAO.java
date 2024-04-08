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
import modelo.Propietario;

public class PropietarioDAO {
    private Connection conexion;

    public PropietarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public PropietarioDAO() {
       
    }


    public boolean registrarPropietario(Propietario propietario) {
        String sql = "INSERT INTO Propietarios (clave, nombre, apellido, fechaNacimiento, email, genero, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, propietario.getClave());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, propietario.getApellido());
            ps.setDate(4, new java.sql.Date(propietario.getFechaNacimiento().getTime()));
            ps.setString(5, propietario.getEmail());
            ps.setString(6, propietario.getGenero());
            ps.setString(7, propietario.getTelefono());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editarPropietario(Propietario propietario) {
        String sql = "UPDATE Propietarios SET clave=?, nombre=?, apellido=?, fechaNacimiento=?, email=?, genero=?, telefono=? WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, propietario.getClave());
            ps.setString(2, propietario.getNombre());
            ps.setString(3, propietario.getApellido());
            ps.setDate(4, new java.sql.Date(propietario.getFechaNacimiento().getTime()));
            ps.setString(5, propietario.getEmail());
            ps.setString(6, propietario.getGenero());
            ps.setString(7, propietario.getTelefono());
            ps.setInt(8, propietario.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarPropietario(int id) {
        String sql = "DELETE FROM Propietarios WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Propietario obtenerPropietarioPorId(int id) {
        String sql = "SELECT * FROM Propietarios WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Propietario propietario = new Propietario();
                    propietario.setId(rs.getInt("id"));
                    propietario.setClave(rs.getString("clave"));
                    propietario.setNombre(rs.getString("nombre"));
                    propietario.setApellido(rs.getString("apellido"));
                    propietario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    propietario.setEmail(rs.getString("email"));
                    propietario.setGenero(rs.getString("genero"));
                    propietario.setTelefono(rs.getString("telefono"));
                    return propietario;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Propietario> listarPropietarios() {
        List<Propietario> propietarios = new ArrayList<>();
        String sql = "SELECT * FROM Propietarios";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Propietario propietario = new Propietario();
                propietario.setId(rs.getInt("id"));
                propietario.setClave(rs.getString("clave"));
                propietario.setNombre(rs.getString("nombre"));
                propietario.setApellido(rs.getString("apellido"));
                propietario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                propietario.setEmail(rs.getString("email"));
                propietario.setGenero(rs.getString("genero"));
                propietario.setTelefono(rs.getString("telefono"));
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return propietarios;
    }
}

