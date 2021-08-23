
package Controllers;

import Gestions.FacturaGestion;
import Models.Factura;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;



@Named(value = "faturaController")
@SessionScoped
public class FaturaController extends Factura implements Serializable {

	/****
	 * Creates a new instance of UsuarioController
	 */
	public FaturaController() {
         super(0, 0, 0, 0, "",0);
    }
	
	public boolean inserta(int idUsuario, int subtotal,String fecha){
        // cambiar a la vista de contactenos de nuevo, esta carga pero con la info previamente ingresada, corregir esto**
        boolean resp=false;
		this.setIdUsuario(idUsuario);
		this.setTotal( subtotal + ((subtotal * 13)/100));
		this.setIva(((subtotal * 13)/100));
		this.setSubtotal(subtotal);
		this.setFecha(fecha);
		this.setNumerofacturas(FacturaGestion.getCantidadDeFacturas(idUsuario) + 1);
		if (FacturaGestion.insertar(this)){
//            return "listComentarios.xhtml";
			resp = true;
            
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("agregaProductoForm:codigo", mensaje);
            resp=false;
        }
        return resp;
    }

	
	
	public List<Factura> getFacturas(){
        
        return FacturaGestion.getFacturas();
        
    }
	
	public Factura getFactura(int idFactura){
        
        return FacturaGestion.getFactura(idFactura);
        
    }
	
	public int getIdFactura(int numerofacturas){
        
        return FacturaGestion.getIdFactura(numerofacturas);
        
    }
}
