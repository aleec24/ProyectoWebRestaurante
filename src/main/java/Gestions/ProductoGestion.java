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
import Models.Producto;

public class ProductoGestion {

	private static final String SQL_INSERT_PRODUCTO= "insert into producto (codigo,nombre,precio,estado,descripcion) values (?,?,?,?,?)";

	public static boolean insertar(Producto producto){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_PRODUCTO);
            sentencia.setInt(1, producto.getCodigo());
            sentencia.setString(2, producto.getNombre());
            sentencia.setInt(3,producto.getPrecio());
			sentencia.setString(4,producto.getEstado());
			sentencia.setString(5,producto.getDescripcion());
            return sentencia.executeUpdate()>0; // Retorna true si lo logra insertar, false si no
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false; // No se logró insertar.
        
    }
	
	// Declaración de Query y método para consultar la lista de estudiantes en base de datos
    
    private static final String SQL_SELECT_PRODUCTOS="Select * from producto";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";
    
    public static ArrayList<Producto> getProductos(){
        
        ArrayList<Producto> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Producto(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(8)));           
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return lista;     
    }
	
	// Declaración de Query y método para consultar la lista de estudiantes en base de datos
    
    private static final String SQL_SELECT_PRODUCTOSCODIGO="Select * from producto where codigo>=? and codigo<?+100";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";
    
    public static ArrayList<Producto> getProductosCodigo(int codigo){
        
        ArrayList<Producto> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOSCODIGO);
			consulta.setInt(1, codigo);
			consulta.setInt(2, codigo);
			ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Producto(rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(8)));           
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return lista;     
    }
	
	private static final String SQL_UPDATE_PRODUCTO= "update producto set nombre=?,precio=?,estado=?,descripcion=?,nombreImagen=? where codigo=?";
    public static boolean actualiza (Producto producto){
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_PRODUCTO);
            sentencia.setString(1, producto.getNombre());
            sentencia.setInt(2, producto.getPrecio());
			sentencia.setString(3, producto.getEstado());
			sentencia.setString(4, producto.getDescripcion());
			sentencia.setString(5, producto.getNombreImagen());
			sentencia.setInt(6,producto.getCodigo());
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	private static final String SQL_SELECT_PRODUCTO= "select * from producto where codigo=?";
    
    
    public static Producto getProducto(int codigo){
        
        Producto producto=null;
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTO);
            consulta.setString(1, String.valueOf(codigo));
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                producto= new Producto(
                datos.getInt(2),//codigo
                datos.getString(3),//nombre
                datos.getInt(4),//precio
				datos.getString(5),//estado
				datos.getString(6),//descripcion 
				datos.getString(8));//nombre de imagen 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return producto;
        
    }
	
	private static final String SQL_DELETE_PRODUCTO= "delete from producto where codigo=?";
    
    public static boolean eliminar (int codigo){
        
        try {
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_DELETE_PRODUCTO);
            consulta.setString(1,String.valueOf(codigo));
            return consulta.executeUpdate()>0; // Si es mayor quiere decir que lo borró y retorna true, de lo contrario
            //false
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false;
        
    }
	
	
}
