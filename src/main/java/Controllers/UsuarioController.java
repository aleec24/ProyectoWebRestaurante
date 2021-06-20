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
        try {
            usuario = UsuarioGestion.Valida(this.getIdUsuario(), this.getPwUsuario());
            if (usuario != null) {
                this.setIdUsuario(usuario.getIdUsuario());
                this.setNombreUsuario(usuario.getNombreUsuario());
                this.setIdRol(usuario.getIdRol());
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
}
