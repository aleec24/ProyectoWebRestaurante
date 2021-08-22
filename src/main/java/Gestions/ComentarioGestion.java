package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;
import Models.Comentario;

public class ComentarioGestion {

	private static final String SQL_INSERT_COMENTARIO= "insert into comentario (nombre,telefono,correo,comentario) values (?,?,?,?)";

	public static boolean insertar(Comentario comentario){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_COMENTARIO);
            sentencia.setString(1, comentario.getNombre());
            sentencia.setInt(2, comentario.getTelefono());
            sentencia.setString(3,comentario.getCorreo());
			sentencia.setString(4,comentario.getComentario());
            return sentencia.executeUpdate()>0; // Retorna true si lo logra insertar, false si no
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false; // No se logró insertar.
        
    }
	
	// Declaración de Query y método para consultar la lista de estudiantes en base de datos
    
    private static final String SQL_SELECT_COMENTARIOS="Select * from comentarios";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";
    
    public static ArrayList<Comentario> getComentarios(){
        
        ArrayList<Comentario> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_COMENTARIOS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Comentario(rs.getInt(3),rs.getString(2),rs.getString(4),rs.getString(5)));            
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return lista;     
    }
	
	private static final String SQL_UPDATE_COMENTARIO= "update comentarios set nombre=?,telefono=?,"
            + "correo=?, comentario=? where nombre=?";
    
    public static boolean actualiza (Comentario comentario){
        
        
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_COMENTARIO);
            sentencia.setString(1, comentario.getNombre());
            sentencia.setInt(2, comentario.getTelefono());
            sentencia.setString(3, comentario.getCorreo());
			sentencia.setString(4, comentario.getComentario());
                        sentencia.setString(5, comentario.getNombre());
                        
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	private static final String SQL_SELECT_COMENTARIO= "select * from comentarios where nombre=?";
    
    
    public static Comentario getComentario(String nombre){
        
        Comentario comentario=null;
        
        try {
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COMENTARIO);
            consulta.setString(1, nombre);
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                comentario= new Comentario(
                datos.getInt(3),//telefono
                datos.getString(2),//nombre
                datos.getString(4),//correo
				datos.getString(5));//comentario   
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return comentario;
        
    }
	
	private static final String SQL_DELETE_COMENTARIO= "delete from comentarios where nombre=?";
    
    public static boolean eliminar (String nombre){
        
        try {
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_DELETE_COMENTARIO);
            consulta.setString(1,nombre);
            return consulta.executeUpdate()>0; // Si es mayor quiere decir que lo borró y retorna true, de lo contrario
            //false
        } catch (SQLException ex) {
            Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ComentarioGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false;
        
    }
	
}
