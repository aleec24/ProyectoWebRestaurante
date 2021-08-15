package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import Models.Usuario;
import java.util.ArrayList;

public class UsuarioGestion {

    private static final String SQL_VALIDA = "select id,nombre,rol,correo from usuario where nombreUsuario=?"
            + " and claveUsuario=?";

    public static Usuario Valida(String nombreUsuario, String pwUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_VALIDA);
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, pwUsuario);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {

                usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
	
	private static final String SQL_SELECT_OBTENERID = "SELECT id FROM usuario where nombreUsuario=?";

    public static ArrayList<Usuario> obtenerId(String nombreUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
		ArrayList<Usuario> lista= new ArrayList<>();
        boolean usuarioEncontrado = false;
		int idUsuario = 0;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_OBTENERID);
            sentencia.setString(1, nombreUsuario);
            ResultSet rs = sentencia.executeQuery();

			while (rs!=null && rs.next()){
                lista.add(new Usuario(rs.getString(1)));         
				usuarioEncontrado = true;
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		if (!usuarioEncontrado) {
			Usuario usuario = new Usuario("0");
			lista.add(usuario);
		}
		
        return lista;
    }
	
	private static final String SQL_SELECT_OBTENERCORREO = "SELECT id,correo FROM deweb.usuario WHERE nombre=? and apellido=? and cedula=?";

    public static ArrayList<Usuario> obtenerCorreo(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
		ArrayList<Usuario> lista= new ArrayList<>();
        boolean usuarioEncontrado = false;
		int idUsuario = 0;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_OBTENERCORREO);
            sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, cedula);
			ResultSet rs = sentencia.executeQuery();

			while (rs!=null && rs.next()){
                lista.add(new Usuario(rs.getString(1),rs.getString(2)));         
				usuarioEncontrado = true;
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		if (!usuarioEncontrado) {
			Usuario usuario = new Usuario("0","NO");
			lista.add(usuario);
		}
		
        return lista;
    }
	
	private static final String SQL_SELECT_OBTENERCLAVE = "SELECT id,claveUsuario FROM deweb.usuario WHERE nombre=? and apellido=? and cedula=?";

    public static String obtenerClave(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        
		ArrayList<Usuario> lista= new ArrayList<>();
        boolean usuarioEncontrado = false;
		String resp = "";
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_OBTENERCLAVE);
            sentencia.setString(1, nombre);
			sentencia.setString(2, apellido);
			sentencia.setString(3, cedula);
			ResultSet rs = sentencia.executeQuery();

			while (rs!=null && rs.next()){
                resp = rs.getString(2);
				usuarioEncontrado = true;
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		if (!usuarioEncontrado) {
//			Usuario usuario = new Usuario();
//			usuario.setPwUsuario("NO");
//			usuario.setId("NO");
//			lista.add(usuario);
			resp = "NO";
		}
		
        return resp;
    }
	
	
}
