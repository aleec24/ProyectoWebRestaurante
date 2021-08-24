
package Controllers;

import Gestions.CarritoGestion;
import Models.Carrito;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;



@Named(value = "carritoController")
@SessionScoped
public class CarritoController extends Carrito implements Serializable {

	/****
	 * Creates a new instance of loginController
	 */
	
	
	
	public CarritoController() {
         
    }
	public boolean inserta(int idUsuario) {
		boolean result = false;
		ArrayList<Carrito> lista = CarritoGestion.getCarritoid(idUsuario);
		Carrito carrito = lista.get(0);
		if (carrito.getIdCarrito() != 0 && carrito.getIdCarrito() > 0) { // Solo si no hay un carrito asignado al usuario
			result = false;
		} else {
			this.setIdUsuario(idUsuario);
			this.setEstadoCarrito("vacio");
			this.setCarritoActivo(1);
			if (CarritoGestion.insertar(this)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
	
	public boolean agregarACarrito(int idCarrito, int idProducto, int cantidad) {
		boolean result = false;
		if (cantidad != 0) {

			int cantidadDB = CarritoGestion.getCantidadProducto(idCarrito, idProducto);
			if (cantidadDB == 0) {
				if (CarritoGestion.agregarProducto(idCarrito, idProducto, cantidad)) {
					result = true;
					CarritoGestion.actualiza("pendiente", idCarrito);
				} else {

					FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error", "Posible error en datos ingresados");
					FacesContext.getCurrentInstance().addMessage("agregaCarritoForm:identificacion", mensaje);
					result = false;
				}
			} else {
				if (CarritoGestion.actualizaCarritoCantidad(cantidad + cantidadDB, idCarrito, idProducto)) {
					result = true;
				} else {
					result = false;
				}
			}
		}

		return result;
	}
	
	public boolean modifica(boolean estadoCarrito, int idUsuario){
		boolean result = false;
        if(estadoCarrito == false){
			this.setEstadoCarrito("vacio");
		}else{
			this.setEstadoCarrito("pendiente");
		}
		
        if (CarritoGestion.actualiza(this.getEstadoCarrito(), idUsuario)){
            result = true;
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("editaComentarioForm:identificacion", mensaje);
            return result = false;
        }
		return result;
    }
	
	public int obtenerIdCarrito(int idUsuario){
		int result = 0;
        ArrayList<Carrito> lista = CarritoGestion.getCarritoid(idUsuario);
		Carrito carrito = lista.get(0);
		
		return result=carrito.getIdCarrito();
    }
	
	
	
	public List<Carrito> getCarritos(){
        
        return CarritoGestion.getCarritos();
        
    }
	
	
	
	
}
