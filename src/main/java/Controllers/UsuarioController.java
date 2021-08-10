/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Gestions.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Models.Usuario;

@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        super("", "", "");
    }

    public String valida() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, InvocationTargetException {
        Usuario usuario;
        String ret = "";
		int idUsuario = 0;
        try {
            usuario = UsuarioGestion.Valida(this.getNombreUsuario(), this.getPwUsuario());
            if (usuario != null) {
                CarritoController carritoController = new CarritoController();
				carritoController.inserta(Integer.parseInt(usuario.getId())); // Solo si no hay un carrito asignado al usuario
				carritoController = null;
                this.setNombre(usuario.getNombre());
				this.setIdRol(usuario.getIdRol());
				this.setPwUsuario("");
				ret = "principal.xhtml";
            } else {
                // Mensaje Error
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario y/o contraseña invalidas");
                FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);

                ret = "index.xhml";
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public String getPlantilla() {
        if(!this.getIdUsuario().equals("")) {
            return "./resources/plantilla/plantilla.xhtml";
        } else {
            return "./resources/plantilla/plantilla.xhtml";
        }
    }
}
