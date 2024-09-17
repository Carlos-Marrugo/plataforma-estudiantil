package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class userSearch {

    public boolean accesoUsuario(String user, String pass) {
        ConexionDB db = new ConexionDB();
        boolean accesoCorrecto = false;

        try {
            Connection cn = db.conectar();
            String sql = "SELECT usuario, contraseña FROM usuarios WHERE usuario = ? AND contraseña = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                accesoCorrecto = true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return accesoCorrecto;
    }
}
