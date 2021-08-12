
package Models;

import java.util.ArrayList;


public class WebVars {
	
	//////////////////////////////////////////
	//// Para agregar producto a carrito  ////
	//////////////////////////////////////////
	
	public int cantidad;
	
	

	public WebVars(int cantidad) {
		this.cantidad = cantidad;
	}

	public WebVars() {
	}

	
	
	
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
}
