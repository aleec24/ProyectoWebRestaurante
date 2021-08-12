
package Controllers;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "webvarsController")
@SessionScoped
public class WebVarsController implements Serializable {

	private int cantidad;
	
		
	public WebVarsController() {
         
    }

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
}
