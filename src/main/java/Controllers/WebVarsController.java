
package Controllers;


import Gestions.CarritoGestion;
import Gestions.CarritoProductoGestion;
import Gestions.DetalleVentasGestion;
import Gestions.FacturaGestion;
import Gestions.UsuarioGestion;
import Models.CarritoProducto;
import Models.Correo;
import Models.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.mail.MessagingException;


@Named(value = "webvarsController")
@SessionScoped
public class WebVarsController implements Serializable {

	private int cantidad;
	private boolean toggle;
		
	public WebVarsController() {
         
    }

	public boolean isToggle() {
		return toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String facturar(int idUsuario, int subtotal,String fecha, ArrayList<CarritoProducto>  CarritoProducto,int idCarrito) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, MessagingException{
		int idFacturas = 0;
		Usuario usuario = UsuarioGestion.selectUsuario(idUsuario);
		String cuerpoCorreo = "";
		cuerpoCorreo = fecha + "\n" 
				+ "Hola " + usuario.getNombre() + " " + usuario.getApellido() + " " + "Soda Restaurante le informa de los detalles de su compra.\n";
		
		
		FaturaController facturaController = new FaturaController();
		facturaController.inserta(idUsuario, subtotal,fecha);
		
		idFacturas = facturaController.getIdFactura(FacturaGestion.getCantidadDeFacturas(idUsuario));
		
		DetalleVentasController detalleVentasController = new DetalleVentasController();
		
		int cantidadProductos = CarritoProducto.size();
		
		
		
		for (int i = 0; i < cantidadProductos; i++) {
			detalleVentasController.setIdFactura(idFacturas);
			detalleVentasController.setIdProducto(CarritoProducto.get(i).getIdProducto());
			detalleVentasController.setCantidad(CarritoProducto.get(i).getCantidadUni());
			detalleVentasController.setPrecioUnitario(CarritoProducto.get(i).getPrecioTotal());

			DetalleVentasGestion.insertar(detalleVentasController);
			
			cuerpoCorreo += "\n" + "Codigo - " + CarritoProducto.get(i).getIdProducto() + "    Nombre - " + CarritoProducto.get(i).getNombreProducto() + "    Cantidad - " + CarritoProducto.get(i).getCantidadUni() + "    Precio - " + CarritoProducto.get(i).getPrecioTotal();
		}

		
		CarritoProductoGestion.actualizaEstadoCarritoProducto(idCarrito);
		CarritoGestion.actualiza("vacio", idCarrito);
		
		cuerpoCorreo += "\n\n" + "subtotal: " + subtotal;
		cuerpoCorreo += "\n" + "iva: " + ((subtotal * 13)/100);
		cuerpoCorreo += "\n" + "Total a pagar: " +( subtotal + ((subtotal * 13)/100));
		
		Correo correo = new Correo(usuario.getCorreo());
		correo.enviarCorreoFactura(cuerpoCorreo);
		
		String resp = "principal.xhtml";
		
		return resp;
	}
	
	public String getFecha(){
		String fechaActual = null;
		Calendar fecha = new GregorianCalendar();
		fechaActual = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH)) + "-" + String.valueOf(fecha.get(Calendar.MONTH)) + "-" + String.valueOf(fecha.get(Calendar.YEAR));
		return fechaActual;
	}
	
	
	public boolean togglestate(){
		this.toggle = true;
		
		return toggle;
	}
	
	
}
