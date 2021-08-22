
package Controllers;

import Gestions.ComentarioGestion;
import Models.Comentario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;



@Named(value = "comentarioController")
@SessionScoped
public class ComentarioController extends Comentario implements Serializable {

	/****
	 * Creates a new instance of loginController
	 */
	public ComentarioController() {
         
    }
	
	public String inserta(){
        // cambiar a la vista de contactenos de nuevo, esta carga pero con la info previamente ingresada, corregir esto**
        if (ComentarioGestion.insertar(this)){
//            return "listComentarios.xhtml";
            return "agregaComentarios.xhtml";
            
        }else{
            
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("agregaComentarioForm:identificacion", mensaje);
            return "agregaComentarios.xhtml";
        }
        
    }
	
	public String modifica(){
        
        if (ComentarioGestion.actualiza(this)){
            return "listComentarios.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("editaComentarioForm:identificacion", mensaje);
            return "listEditaComentarios.xhtml";   
        }
    }
	
	public String edita(String nombre){
        
        Comentario comentario= ComentarioGestion.getComentario(nombre);
        if (comentario!=null){
            
            this.setNombre(comentario.getNombre());
            this.setTelefono(comentario.getTelefono());
            this.setCorreo(comentario.getCorreo());
			this.setComentario(comentario.getComentario());
            
            return "editaComentario.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "listEditaComentarios.xhtml";
            
        }

    }
	
	
	
	
	public String elimina(String nombre){
        
        if (ComentarioGestion.eliminar(nombre)){
            return "listComentarios.xhtml";
        }else{
             FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Error", "Posible que el nombre no exista");
            FacesContext.getCurrentInstance().addMessage("editaJuegoForm:identificacion", mensaje);
            return "listEliminaComentario.xhtml";
            
        }
   
    }
	
//	public List<Comentario> getComentarios(){
//        
//        return ComentarioGestion.getComentarios();
//        
//    }
}
