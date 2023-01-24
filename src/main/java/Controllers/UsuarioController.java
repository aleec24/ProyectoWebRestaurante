package Controllers;

import Gestions.UsuarioGestion;
import Models.Usuario;
import Models.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    /**
     * **
     * Creates a new instance of loginController
     */
    public UsuarioController() {

    }

    public String inserta() {
        // cambiar a la vista de contactenos de nuevo, esta carga pero con la info previamente ingresada, corregir esto**
        if (UsuarioGestion.insertar(this)) {
            this.setId("");
            this.setNombre("");
            this.setApellido("");
            this.setCedula("");
            this.setTelefono("");
            this.setRol("");
            this.setNombreUsuario("");
            this.setPwUsuario("");
            this.setEstado(true);
            this.setCorreo("");
            return "agregaUsuario.xhtml";

        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("agregaUsuarioForm:codigo", mensaje);
            return "agregaUsuarios.xhtml";
        }

    }

    public String modifica() {

        if (UsuarioGestion.actualiza(this)) {
            return "listaUsuarios.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible error en datos ingresados");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:codigo", mensaje);
            return "editaUsuario.xhtml";
        }
    }

    public String edita(int id) {

        Usuario usuario = UsuarioGestion.getUsuario(id);
        if (usuario != null) {
            this.setId(usuario.getId());
            this.setNombre(usuario.getNombre());
            this.setApellido(usuario.getApellido());
            this.setCedula(usuario.getCedula());
            this.setTelefono(usuario.getTelefono());
            this.setRol(usuario.getRol());
            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setPwUsuario(usuario.getPwUsuario());
            this.setEstado(usuario.getEstado());
            this.setCorreo(usuario.getCorreo());

            return "editaUsuario.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el id no exista");
            FacesContext.getCurrentInstance().addMessage("listForm", mensaje);
            return "listEditaUsuario.xhtml";
        }

    }

    public String elimina(int codigo) {

        if (UsuarioGestion.eliminar(codigo)) {
            return "listaUsuarios.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posible que el codigo no exista");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm:identificacion", mensaje);
            return "listEliminaUsuario.xhtml";
        }

    }

    public List<Usuario> getUsuarios() {
        return UsuarioGestion.getUsuarios();
    }

    public Usuario getUsuario(int id) {
        return UsuarioGestion.getUsuario(id);
    }
}
