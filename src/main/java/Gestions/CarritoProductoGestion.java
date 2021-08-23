package Gestions;

import Models.CarritoProducto;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;


public class CarritoProductoGestion {

	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// INSERT
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	

	
	//*****************************************************
	//*****************************************************	
	
	private static final String SQL_SELECT_CARRITOPRODUCTOS= 
			"SELECT carrito.estadoCarrito , producto.nombre , carrito_producto.idProducto , carrito_producto.estadoCompra\n"
			+ "FROM carrito\n"
			+ "	INNER JOIN carrito_producto ON \n"
			+ "	  carrito.idCarrito =  carrito_producto.idCarrito\n"
			+ "	INNER JOIN producto ON \n"
			+ "	  producto.idProducto = carrito_producto.idProducto\n"
			+ "WHERE \n"
			+ "	carrito.idUsuario = ?";
    
    
    public static String [] getProducto(int codigo){
        
        String [] query=null;
        
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CARRITOPRODUCTOS);
            consulta.setString(1, String.valueOf(codigo));
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                query [0] = datos.getString(1);// EstadoCarrito
				query [1] = datos.getString(2);// Nombre del producto
				query [2] = datos.getString(3);// Id producto
				query [3] = datos.getString(4);// Estado de compra del producto
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return query;
        
    }
	
	
	//*****************************************************
	//*****************************************************	
	//carrito_producto
	
	private static final String SQL_SELECT_PRODUCTOSENCARRITO= 
			"SELECT producto.nombre, carrito_producto.cantidad, (producto.precio * carrito_producto.cantidad),  producto.nombreImagen, producto.idProducto\n"
			+ "FROM carrito_producto\n"
			+ "INNER JOIN producto ON\n"
			+ "carrito_producto.idProducto = producto.idProducto\n"
			+ "WHERE carrito_producto.idCarrito = ? AND carrito_producto.estadoCompra = ?";

    
    public static ArrayList<CarritoProducto> getProductosEnCarrito(int idCarrito){
        
		ArrayList<CarritoProducto> lista = new ArrayList<>();
        
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOSENCARRITO);
            consulta.setInt(1, idCarrito);
			consulta.setString(2, "pendiente");
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            while (datos!=null && datos.next()){
                lista.add(new CarritoProducto(datos.getString(1),datos.getInt(2), datos.getInt(3),datos.getString(4), datos.getInt(5)));
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return lista;
        
    }
	
	
	private static final String SQL_SELECT_PRODUCTOSENCARRITOPENDIENTES= 
			"SELECT nombre,producto.idProducto, carrito_producto.cantidad , producto.precio\n"
			+ "FROM carrito_producto\n"
			+ "INNER JOIN producto ON\n"
			+ "carrito_producto.idProducto = producto.idProducto\n"
			+ "WHERE carrito_producto.idCarrito = ? AND carrito_producto.estadoCompra = ?";

    
    public static  ArrayList<CarritoProducto> getProductosEnCarritoPendientes(int idCarrito){
        
		
		ArrayList<CarritoProducto> lista = new ArrayList<>();
        
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOSENCARRITOPENDIENTES);
            consulta.setInt(1, idCarrito);
			consulta.setString(2, "pendiente");
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            while (datos!=null && datos.next()){
                lista.add(new CarritoProducto(datos.getString(1), datos.getInt(2),datos.getInt(3), datos.getInt(4)));
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return lista;
        
    }
	
	private static final String SQL_SELECT_PRECIOPRODUCTOSENCARRITO= 
		"SELECT SUM(producto.precio * carrito_producto.cantidad)\n"
			+ " FROM carrito_producto\n"
			+ " INNER JOIN producto ON \n"
			+ " carrito_producto.idProducto = producto.idProducto\n"
			+ " WHERE carrito_producto.idCarrito=? AND carrito_producto.estadoCompra=?";

    
    public static ArrayList<CarritoProducto> getPrecioProductosEnCarrito(int idCarrito, int idProducto){
        
		ArrayList<CarritoProducto> lista = new ArrayList<>();
        
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRECIOPRODUCTOSENCARRITO);
            consulta.setInt(1, idCarrito);
			consulta.setString(2, "pendiente");
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            while (datos!=null && datos.next()){
                lista.add(new CarritoProducto(datos.getInt(1)));
            }
			
        } catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return lista;
        
    }
	
	//*****************************************************
	//*****************************************************	
	
	
	// Declaración de Query y método para consultar la lista en base de datos
    
    private static final String SQL_SELECT_CANTIDADPRODUCTO="Select cantidad from carrito_producto where idCarrito=? and idProducto=?";
    
    public static int getCantidadProducto(int idCarrito, int idProducto){
        
       int cantidad = 0;
		ArrayList<String> lista = new ArrayList<>();
		boolean carritoEncontrado = false;
			
        try {
            
			PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CANTIDADPRODUCTO);
			consulta.setInt(1, idCarrito);
			consulta.setInt(2, idProducto);
			ResultSet rs= consulta.executeQuery();
            //cantidad = rs.getInt(1); 
			System.out.println(rs);
			if (rs != null) {
				while (rs != null && rs.next()) {
					lista.add(String.valueOf(rs.getInt(1)));
					carritoEncontrado = true;
				}
				
				if (!lista.isEmpty()) {
					cantidad = Integer.parseInt(lista.get(0));
				} else {
					cantidad = 0;
				}
				
			} else {
				cantidad = 0;
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return cantidad;     
    }
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// UPDATE
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
	
	
	private static final String SQL_UPDATE_ESTADOCARRITO= "update carrito set estadoCarrito=? where idCarrito=?";
    public static boolean actualiza (String estadoCarrito, int idUsuario){
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_ESTADOCARRITO);
            sentencia.setString(1, estadoCarrito);
            sentencia.setInt(2, idUsuario);
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	//*****************************************************
	//*****************************************************
	
	
	private static final String SQL_UPDATE_CARRITOACTIVO= "update carrito set carritoActivo=? where idUsuario=?";
	
    public static boolean actualizaCarritoActivo (int carritoActivo, int idUsuario){
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_CARRITOACTIVO);
            sentencia.setInt(1, carritoActivo);
            sentencia.setInt(2, idUsuario);
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	
	//*****************************************************
	//*****************************************************
	// carrito_producto
	
	private static final String SQL_UPDATE_CARRITOCANTIDAD= "update carrito_producto set cantidad=? where idCarrito=? and idProducto=? and estadoCompra=?";
	
    public static boolean actualizaCarritoCantidad (int cantidad, int idCarrito,int idProducto){
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_CARRITOCANTIDAD);
            sentencia.setInt(1, cantidad);
            sentencia.setInt(2, idCarrito);
			sentencia.setInt(3, idProducto); 
			sentencia.setString(4, "pendiente");
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	private static final String SQL_UPDATE_ESTADOCARRITOPRODUCTO = "UPDATE deweb.carrito_producto\n"
			+ "SET estadoCompra=?\n"
			+ "WHERE idCarrito=? AND estadoCompra=?";
	
    public static boolean actualizaEstadoCarritoProducto (int idCarrito){
        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_UPDATE_ESTADOCARRITOPRODUCTO);
            sentencia.setString(1, "pagado");
            sentencia.setInt(2, idCarrito);
			sentencia.setString(3, "pendiente");
           
            return sentencia.executeUpdate()>0; // Retorna true en caso de poder actualizar, false caso contrario
            
            
        } catch (SQLException ex) {
			
            Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return false;
    }
	
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// DELETE
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
	
	//*****************************************************
	//*****************************************************
	
	
	private static final String SQL_DELETE_BORRARCARRITOPRODUCTO= "DELETE FROM carrito_producto`\n" 
			+ "WHERE idCarrito=? and idProducto=? and estadoCompra=?";

	public static boolean borrarCarritoProducto(int idCarrito, int idProducto){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_DELETE_BORRARCARRITOPRODUCTO);
            sentencia.setInt(1, idCarrito);
            sentencia.setInt(2, idProducto);
			sentencia.setString(3, "pendiente");
            return sentencia.executeUpdate()>0; // Retorna true si lo logra insertar, false si no
            
        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false; // No se logró insertar.
        
    }
	
	
}
