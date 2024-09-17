package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
    private static Connection con = null;
    
    private static final String url = "jdbc:mysql://localhost:3306/login?characterEncoding=utf8";
    private static final String user = "root"; // Ajusta según el usuario de tu BD
    private static final String pass = "";     // Ajusta según la contraseña de tu BD

    public Connection conectar() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión establecida con éxito.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return con;
    }
}

