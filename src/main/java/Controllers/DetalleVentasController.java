
package Controllers;

import Gestions.DetalleVentasGestion;
import Models.DetalleVentas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;



@Named(value = "detalleVentasController")
@SessionScoped
public class DetalleVentasController extends DetalleVentas implements Serializable {

	/****
	 * Creates a new instance of UsuarioController
	 */
	public DetalleVentasController() {
         
    }
	
	public String inserta(){
        // cambiar a la vista de contactenos de nuevo, esta carga pero con la info previamente ingresada, corregir esto**
        if (DetalleVentasGestion.insertar(this)){
//            return "listComentarios.xhtml";
            return "agregaComentarios.xhtml";
            
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("agregaComentarioForm:identificacion", mensaje);
            return "agregaComentarios.xhtml";
        }
        
    }
	
	
	public List<DetalleVentas> getDetalleVentas(){
        
        return DetalleVentasGestion.getDetalleVentas();
        
    }
	
	public List<DetalleVentas> getDetalleVenta(int idFactura){
        
        return DetalleVentasGestion.getDetalleVenta(idFactura);
        
    }
}
