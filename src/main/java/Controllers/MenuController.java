
package Controllers;


import Models.Menu;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "menuController")
@SessionScoped
public class MenuController implements Serializable {

	private int codigoProducto;
	
	public MenuController() {
         
    }

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	
	
	
}
