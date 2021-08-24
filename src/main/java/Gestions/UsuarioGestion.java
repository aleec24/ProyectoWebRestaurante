package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;
import Models.Usuario;

public class UsuarioGestion {

    private static final String SQL_INSERT_USUARIO = "insert into usuario (id, nombre, apellido, cedula, telefono, rol, nombreUsuario, claveUsuario, estado, correo) values (?,?,?,?,?,?,?,?,?,?)";

    public static boolean insertar(Usuario usuario) {

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_INSERT_USUARIO);
            sentencia.setString(1, usuario.getId());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido());
            sentencia.setString(4, usuario.getCedula());
            sentencia.setString(5, usuario.getTelefono());
            sentencia.setString(6, usuario.getRol());
            sentencia.setString(7, usuario.getNombreUsuario());
            sentencia.setString(8, usuario.getPwUsuario());
            sentencia.setBoolean(9, usuario.getEstado());
            sentencia.setString(10, usuario.getCorreo());
            return sentencia.executeUpdate() > 0; // Retorna true si lo logra insertar, false si no

        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; // No se logró insertar.

    }

    // Declaración de Query y método para consultar la lista de estudiantes en base de datos
    private static final String SQL_SELECT_USUARIOS = "select * from usuario";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";

    public static ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Usuario(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getString(10)
                ));
            }

        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // Declaración de Query y método para consultar la lista de estudiantes en base de datos
    private static final String SQL_SELECT_USUARIO = "Select * from usuario where id=?";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";

    public static Usuario getUsuario(int codigo) {

        Usuario usuario = new Usuario();

        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIO);
            consulta.setInt(1, codigo);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                usuario = new Usuario(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getString(10)
                );
            }

        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    private static final String SQL_UPDATE_USUARIO = "update usuario set nombre=?,apellido=?,cedula=?,telefono=?,rol=?,nombreUsuario=?,claveUsuario=?,estado=?,correo=? where id=?";

    public static boolean actualiza(Usuario usuario) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATE_USUARIO);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getCedula());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getRol());
            sentencia.setString(6, usuario.getNombreUsuario());
            sentencia.setString(7, usuario.getPwUsuario());
            sentencia.setBoolean(8, usuario.getEstado());
            sentencia.setString(9, usuario.getCorreo());
            sentencia.setString(10, usuario.getId());

            return sentencia.executeUpdate() > 0; // Retorna true en caso de poder actualizar, false caso contrario

        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {

            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_DELETE_CARRITO = "delete from carrito where idUsuario=?";
    private static final String SQL_DELETE_USUARIO = "delete from usuario where id=?";

    public static boolean eliminar(int id) {

        try {
            PreparedStatement consultaCarrito = Conexion.getConexion().prepareStatement(SQL_DELETE_CARRITO);
            consultaCarrito.setString(1, String.valueOf(id));
            consultaCarrito.executeUpdate();

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_DELETE_USUARIO);
            consulta.setString(1, String.valueOf(id));
            return consulta.executeUpdate() > 0; // Si es mayor quiere decir que lo borró y retorna true, de lo contrario
            //false
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
}
