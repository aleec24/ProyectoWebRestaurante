
package Controllers;

import Gestions.ComentarioGestion;
import Gestions.ProductoGestion;
import Models.Comentario;
import Models.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;



@Named(value = "productoController")
@SessionScoped
public class ProductoController extends Producto implements Serializable {

	/****
	 * Creates a new instance of UsuarioController
	 */
	public ProductoController() {
         
    }
	
	public String inserta(){
        // cambiar a la vista de contactenos de nuevo, esta carga pero con la info previamente ingresada, corregir esto**
        if (ProductoGestion.insertar(this)){
//            return "listComentarios.xhtml";
            return "agregaProducto.xhtml";
            
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("agregaProductoForm:codigo", mensaje);
            return "agregaProductos.xhtml";
        }
        
    }
	
	public String modifica(){
        
        if (ProductoGestion.actualiza(this)){
            return "listaProductos.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("editaProductoForm:codigo", mensaje);
            return "editaProducto.xhtml";   
        }
    }
	
	public String edita(int codigo){
        
        Producto producto= ProductoGestion.getProducto(codigo);
        if (producto!=null){
            this.setCodigo(producto.getCodigo());
            this.setNombre(producto.getNombre());
            this.setPrecio(producto.getPrecio());
			this.setEstado(producto.getEstado());
            this.setDescripcion(producto.getDescripcion());
			this.setNombreImagen(producto.getNombreImagen());
            
            return "editaProducto.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "listEditaProducto.xhtml";
            
        }

    }
	
	
	
	
	public String elimina(int codigo){
        
        if (ProductoGestion.eliminar(codigo)){
            return "listaProductos.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el codigo no exista");
            FacesContext.getCurrentInstance().addMessage("editaProductoForm:identificacion", mensaje);
            return "listEliminaProducto.xhtml";
            
        }
   
    }
	
	public List<Producto> getProductos(){
        
        return ProductoGestion.getProductos();
        
    }
}
