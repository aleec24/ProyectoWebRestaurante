
package Controllers;

import Gestions.CarritoProductoGestion;
import Models.Carrito;
import Models.CarritoProducto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;



@Named(value = "carritoProductoController")
@SessionScoped
public class CarritoProductoController extends Carrito implements Serializable {

	/****
	 * Creates a new instance of loginController
	 * @param idCarrito
	 * @return 
	 */
	
	

	
	public List<CarritoProducto> getProductosCarrito(int idCarrito){
        return CarritoProductoGestion.getProductosEnCarrito(idCarrito);
	}
	
	public List<CarritoProducto> getProductosCarritoPendientes(int idCarrito){
        return CarritoProductoGestion.getProductosEnCarritoPendientes(idCarrito);
	}
	
	public int getPrecioProductosCarrito(int idCarrito, int idProducto){
		List<CarritoProducto> carritoProductoList = CarritoProductoGestion.getPrecioProductosEnCarrito(idCarrito, idProducto);
		CarritoProducto carritoProducto = carritoProductoList.get(0);
		return carritoProducto.getPrecioTotal();
	}
	
	public int getCantidadProductosCarrito(int idCarrito){
		List<CarritoProducto> carritoProducto = CarritoProductoGestion.getProductosEnCarrito(idCarrito);
		return carritoProducto.size();
		
	}
	
	public boolean borrarProductoCarrito(int idCarrito, int idProducto){
		boolean resp = false;
		if (CarritoProductoGestion.borrarCarritoProducto(idCarrito, idCarrito)) {
			resp = true;
		}
		return resp;
	}
	
	
}
