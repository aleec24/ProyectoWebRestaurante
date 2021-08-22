/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Gestions.LoginGestion;
import Models.Correo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Models.Usuario;
import java.util.ArrayList;
import javax.mail.MessagingException;

@Named(value = "loginController")
@SessionScoped
public class LoginController extends Usuario implements Serializable {

    /**
     * Creates a new instance of loginController
     */
    public LoginController() {
        super("", "", "", "");
    }

    public String valida() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, InvocationTargetException {
        Usuario usuario;
        String ret = "";
        int idUsuario = 0;
        try {
            usuario = LoginGestion.Valida(this.getNombreUsuario(), this.getPwUsuario());
            if (usuario != null) {
                CarritoController carritoController = new CarritoController();
                carritoController.inserta(Integer.parseInt(usuario.getId())); // Solo si no hay un carrito asignado al usuario
                carritoController = null;
                this.setNombre(usuario.getNombre());
                this.setRol(usuario.getRol());
                this.setPwUsuario("");
                if (this.getRol().equals("Admin")) {
                    ret = "principal_admin.xhtml";
                } else {
                    ret = "principal.xhtml";
                }

            } else {
                // Mensaje Error
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario y/o contraseña invalidas");
                FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);

                ret = "index.xhml";
            }
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public int obtenerID(String nombreUsuario) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        int result;
        ArrayList<Usuario> lista = LoginGestion.obtenerId(nombreUsuario);
        Usuario usuario = lista.get(0);

        return result = Integer.parseInt(usuario.getId());

    }

    public String obtenerCorreo(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {

        String result;
        ArrayList<Usuario> lista = LoginGestion.obtenerCorreo(nombre, apellido, cedula);
        Usuario usuario = lista.get(0);

        return result = usuario.getCorreo();

    }

    public String getPlantilla() {
        if (!this.getRol().equals("")) {
            return "./resources/plantilla/plantilla.xhtml";
        } else {
            return "./resources/plantilla/plantilla.xhtml";
        }
    }

    public boolean enviarCorreoContrasena(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, MessagingException {
        boolean resp = false;
        String correo = buscarCorreoValido(nombre, apellido, cedula);
        String clave = buscarContrasena(nombre, apellido, cedula);
        if (!correo.equals("") && !clave.equals("")) {
            enviarCorreo(correo, clave);
            resp = true;
        }

        return resp;
    }

    private String buscarCorreoValido(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String resp = "";
        LoginGestion usuarioGestion = new LoginGestion();
        ArrayList<Usuario> lista = usuarioGestion.obtenerCorreo(nombre, apellido, cedula);
        Usuario usuario = lista.get(0);
        return resp = usuario.getCorreo();
    }

    private String buscarContrasena(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        String resp = "";
        LoginGestion usuarioGestion = new LoginGestion();
        resp = usuarioGestion.obtenerClave(nombre, apellido, cedula);
        return resp;
    }

    private boolean enviarCorreo(String correo, String clave) throws MessagingException {
        boolean resp = false;
        Correo oCorreo = new Correo(correo);
        oCorreo.enviarCorreoContraseña(clave);
        resp = true;
        return resp;
    }

    public String recupera() {
        return "recuperacionContrasena.xhtml";
    }

    public void reset() {
        this.setNombre("");
        this.setApellido("");
        this.setCedula("");
    }

}
