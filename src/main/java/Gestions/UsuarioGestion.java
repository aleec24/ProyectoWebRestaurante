package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import Models.Usuario;

public class UsuarioGestion {

    private static final String SQL_VALIDA = "select id,nombre,rol from usuario where nombreUsuario=?"
            + " and claveUsuario=?";

    public static Usuario Valida(String nombreUsuario, String pwUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, pwUsuario);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {

                usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
	
	private static final String SQL_SELECT_OBTENERID = "SELECT id FROM usuario where nombreUsuario=?";

    public static int obtenerId(String nombreUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        int idUsuario = 0;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_OBTENERID);
            sentencia.setString(1, nombreUsuario);
            ResultSet rs = sentencia.executeQuery();

            idUsuario = Integer.parseInt( rs.getString(1));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUsuario;
    }
	
}
