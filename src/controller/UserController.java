package controller;

import com.mysql.jdbc.Statement;
import javax.swing.JOptionPane;
import model.Conexion;
import model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class UserController {

    //Login Method
    public boolean loginUser(User user) throws SQLException {
        boolean respuesta = false;

        Connection cn = Conexion.getConexion();
        String sql = "select email, password FROM usuarios where email = '" + user.getEmail() + "' and password = '" + user.getPassword() + "'";

        Statement st;
        try {

            st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return true;
    }
}
