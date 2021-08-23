package Gestions;

import Models.Carrito;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;


public class CarritoGestion {

	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// INSERT
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
	private static final String SQL_INSERT_CARRITO= "insert into carrito (idUsuario,estadoCarrito,carritoActivo) values (?,?,?)";

	public static boolean insertar(Carrito carrito){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_CARRITO);
            sentencia.setInt(1, carrito.getIdUsuario());
            sentencia.setString(2, carrito.getEstadoCarrito());
			sentencia.setInt(3, carrito.getCarritoActivo());
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
	
	//*****************************************************
	//*****************************************************
	
	
	private static final String SQL_INSERT_AGREGARCARRITO= "insert into carrito_producto (idCarrito,idProducto,estadoCompra,cantidad) values (?,?,?,?)";

	public static boolean agregarProducto(int idCarrito, int idProducto,int cantidad){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_AGREGARCARRITO);
            sentencia.setInt(1, idCarrito);
            sentencia.setInt(2, idProducto);
			sentencia.setString(3, "pendiente");
			sentencia.setInt(4, cantidad);
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
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// SELECT
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
	// Declaración de Query y método para consultar la lista en base de datos
    
    private static final String SQL_SELECT_CARRITOS="Select * from carrito";
    
    public static ArrayList<Carrito> getCarritos(){
        
        ArrayList<Carrito> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CARRITOS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Carrito(rs.getInt(1),rs.getInt(2),rs.getString(3)));           
            }

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
        return lista;     
    }
	
	//*****************************************************
	//*****************************************************
	
	// Declaración de Query y método para consultar la lista en base de datos
    
    private static final String SQL_SELECT_CARRITOUSUARIO="Select idCarrito from carrito where idUsuario=?";
    
    public static ArrayList<Carrito> getCarritoid(int idUsuario){
        
        ArrayList<Carrito> lista= new ArrayList<>();
        boolean carritoEncontrado = false;
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CARRITOUSUARIO);
			consulta.setInt(1, idUsuario);
			ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Carrito(rs.getInt(1)));         
				carritoEncontrado = true;
            }
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
		if (!carritoEncontrado) {
			Carrito carrito = new Carrito(0);
			lista.add(carrito);
		}
		
        return lista;     
    }
	
	
	
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
        
        return query;
        
    }
	
	
	
	
	//*****************************************************
	//*****************************************************	
	
	
	// Declaración de Query y método para consultar la lista en base de datos
    
    private static final String SQL_SELECT_CANTIDADPRODUCTO="Select cantidad from carrito_producto where idCarrito=? and idProducto=? and estadoCompra=?";
    
    public static int getCantidadProducto(int idCarrito, int idProducto){
        
       int cantidad = 0;
		ArrayList<String> lista = new ArrayList<>();
		boolean carritoEncontrado = false;
			
        try {
            
			PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_CANTIDADPRODUCTO);
			consulta.setInt(1, idCarrito);
			consulta.setInt(2, idProducto);
			consulta.setString(3, "pendiente");
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
        return false;
    }
	
	
	
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	// DELETE
	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
	
	
	
	
	private static final String SQL_DELETE_PRODUCTO= "delete from carrito where codigo=?";
    
    public static boolean eliminar (int codigo){
        
        try {
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_DELETE_PRODUCTO);
            consulta.setString(1,String.valueOf(codigo));
            return consulta.executeUpdate()>0; // Si es mayor quiere decir que lo borró y retorna true, de lo contrario
            //false
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
        
        return false;
        
    }
	
	
	
	
}
