package model;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProfesorDAO {

     public List<Profesor> obtenerProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT codigo_profesor, nombre, apellido, correo_electronico, telefono, materia FROM profesores";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String codigo = rs.getString("codigo_profesor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo_electronico");
                String telefono = rs.getString("telefono");
                String materia = rs.getString("materia");

                Profesor profesor = new Profesor(codigo, nombre, apellido, correo, telefono, materia);
                profesores.add(profesor);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener profesores: " + e.getMessage());
        }

        return profesores;
    }
    
    public void contratarProfesor(String nombre, String apellidos, String correo, String telefono, LocalDate fechaContratacion, String materia) {
    String codigo = generarCodigoProfesor();

    String sql = "INSERT INTO profesores (codigo_profesor, nombre, apellido, correo_electronico, telefono, fecha_contratacion, materia) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = ConexionDB.conectar();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setString(1, codigo);
        pstmt.setString(2, nombre);
        pstmt.setString(3, apellidos);
        pstmt.setString(4, correo);
        pstmt.setString(5, telefono);
        pstmt.setDate(6, java.sql.Date.valueOf(fechaContratacion));
        pstmt.setString(7, materia);

        pstmt.executeUpdate();
        System.out.println("Profesor insertado con exito.");
        
    } catch (SQLException e) {
        System.err.println("Error al insertar el profesor: " + e.getMessage());
    }
}


    private String generarCodigoProfesor() {
        String codigo = "PROF001"; 
        String sql = "SELECT codigo_profesor FROM profesores ORDER BY codigo_profesor DESC LIMIT 1";  

        try (Connection con = ConexionDB.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                String ultimoCodigo = rs.getString("codigo_profesor");
                int numero = Integer.parseInt(ultimoCodigo.substring(4));  
                numero++;
                codigo = String.format("PROF%03d", numero);
            }
        } catch (SQLException e) {
            System.err.println("Error al generar el codigo de profesor: " + e.getMessage());
        }

        return codigo;
    }
    
    
    public void eliminarProfesor(String codigoProfesor) {
        String sql = "DELETE FROM profesores WHERE codigo_profesor = ?";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, codigoProfesor);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Profesor eliminado con éxito.");
            } else {
                System.out.println("No se encontró el profesor con código: " + codigoProfesor);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar profesor: " + e.getMessage());
        }
    }
    
}
