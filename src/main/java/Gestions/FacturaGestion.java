package Gestions;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Conexion;
import java.util.ArrayList;
import Models.Factura;

public class FacturaGestion {

	private static final String SQL_INSERT_FACTURA= "insert into factura (idUsuario,total,iva,subTotal,fecha,numerofacturas) values (?,?,?,?,?,?)";

	public static boolean insertar(Factura factura){

        try {
            PreparedStatement sentencia= Conexion.getConexion().prepareCall(SQL_INSERT_FACTURA);
            sentencia.setInt(1, factura.getIdUsuario());
            sentencia.setInt(2, factura.getTotal());
            sentencia.setInt(3,factura.getIva());
			sentencia.setInt(4,factura.getSubtotal());
			sentencia.setString(5,factura.getFecha());
			sentencia.setInt(6,factura.getNumerofacturas());
            return sentencia.executeUpdate()>0; // Retorna true si lo logra insertar, false si no
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return false; // No se logró insertar.
        
    }
	
	// Declaración de Query y método para consultar la lista de estudiantes en base de datos
    
    private static final String SQL_SELECT_FACTURAS="Select * from factura";
    //private static final String SQL_SELECT_ESTUDIANTES="Select * from estudiante Limit 0,200";
    
    public static ArrayList<Factura> getFacturas(){
        
        ArrayList<Factura> lista= new ArrayList<>();
        
        try {
            
            PreparedStatement consulta= Conexion.getConexion().prepareStatement(SQL_SELECT_FACTURAS);
            ResultSet rs= consulta.executeQuery();
            while (rs!=null && rs.next()){
                lista.add(new Factura(rs.getInt(2),rs.getInt(3),rs.getInt(5),rs.getInt(6),rs.getString(4),rs.getInt(7)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {    
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        return lista;     
    }
	
	
	private static final String SQL_SELECT_FACTURA= "select * from factura where idFactura=?";
    
    
    public static Factura getFactura(int idFactura){
        
        Factura factura=null;
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_FACTURA);
            consulta.setInt(1, idFactura);
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                factura = new Factura(datos.getInt(2),datos.getInt(3),datos.getInt(5),datos.getInt(6),datos.getString(4),datos.getInt(7));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return factura;
        
    }
	
	
	private static final String SQL_SELECT_CANTIDADDEFACTURAS= "SELECT count(*) FROM factura where idUsuario=?";
    
		
	 public static int getCantidadDeFacturas(int idUsuario){
        
        int resp = 0;
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CANTIDADDEFACTURAS);
            consulta.setInt(1, idUsuario);
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                resp = datos.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return resp;
        
    }
	
	 private static final String SQL_SELECT_IDFACTURA= "SELECT idFactura FROM factura where numeroFacturas=?";
    
		
	 public static int getIdFactura(int numeroFacturas){
        
        int resp = 0;
        
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_IDFACTURA);
            consulta.setInt(1, numeroFacturas);
            ResultSet datos= consulta.executeQuery();
            //Si encontró alguna coincidencia
            if (datos.next()){
                resp = datos.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(FacturaGestion.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        return resp;
        
    }
	
	 
}
