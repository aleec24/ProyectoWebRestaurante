package gestion;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author bryansa
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Usuario;

public class UsuarioGestion {

    private static final String SQL_VALIDA = "select nombre, rol from usuario where nombreUsuario=?"
            + " and claveUsuario=?";

    public static Usuario valida(String idUsuario, String pwUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setString(1, idUsuario);
            sentencia.setString(2, pwUsuario);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(idUsuario, rs.getString(1), rs.getString(2));
            }

        } catch (Exception ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
