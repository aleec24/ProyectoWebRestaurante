package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;
import Models.DetalleVentas;

public class DetalleVentasGestion {

	private static final String SQL_INSERT_DETALLEV= "insert into detalle_ventas (idFactura,idProducto,cantidad,precioUnitario) values (?,?,?,?)";

	public static boolean insertar(DetalleVentas detalleVentas){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_DETALLEV);
            sentencia.setInt(1, detalleVentas.getIdFactura());
            sentencia.setInt(2, detalleVentas.getIdProducto());
            sentencia.setInt(3,detalleVentas.getCantidad());
			sentencia.setInt(4,detalleVentas.getPrecioUnitario());
            return sentencia.executeUpdate()>0; // Retorna true si lo logra insertar, false si no
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false; // No se logró insertar.
        
    }
	
	// Declaración de Query y método para consultar la lista de estudiantes en base de datos
    
    private static final String SQL_SELECT_DETALLEVS="Select * from detalle_ventas";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";
    
    public static ArrayList<DetalleVentas> getDetalleVentas(){
        
        ArrayList<DetalleVentas> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_DETALLEVS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new DetalleVentas(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));           
            }

        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return lista;     
    }
	
	
	
	private static final String SQL_SELECT_SQL_SELECT_DETALLEV= "select * from detalle_ventas where idFactura=?";
    
    
    public static ArrayList<DetalleVentas> getDetalleVenta(int idFactura){
        
        ArrayList<DetalleVentas> lista= new ArrayList<>();
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SQL_SELECT_DETALLEV);
            consulta.setInt(1, idFactura);
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
              lista.add(new DetalleVentas(datos.getInt(2),datos.getInt(3),datos.getInt(4),datos.getInt(5)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DetalleVentasGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return lista;
        
    }
	
	
	
	
}
