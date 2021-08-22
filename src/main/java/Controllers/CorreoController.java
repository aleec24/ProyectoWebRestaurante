/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Models.Correo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import javax.mail.MessagingException;


@Named(value = "correoController")
@SessionScoped
public class CorreoController extends Correo implements Serializable {

	private static final long serialVersionUID = 1L;

    

    public CorreoController() {
    }

	public CorreoController(String correoReceptor) {
		super(correoReceptor);
	}
     
	public void recuperarContrasena(String nombre, String apellido, String cedula) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, MessagingException{
		Boolean resp = false;
		LoginController loginController = new LoginController();
		if (loginController.enviarCorreoContrasena(nombre, apellido, cedula)) {
			resp = true;
		} 

		
		//return resp;
	}
	
	
}
