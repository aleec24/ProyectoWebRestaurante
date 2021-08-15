/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author bryansa
 */
public class Correo {

	Properties props = new Properties();
	String correoReceptor = "";

	public Correo() {
	}
	
	public Correo(String correoReceptor) {
		this.correoReceptor = correoReceptor;
	}
	
	

	public void enviarCorreoContraseña(String contrasena) throws AddressException, MessagingException {

		try {
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);

			String correoRemitente = "aplicaciongym2021@gmail.com";
			String passwordRemitente = "appGYM2021+";
			
			String asunto = "Soda Restaurante";
			String mensaje = "Soda Restaurante le informa que su contraseña es : \n" + contrasena ;

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport t = session.getTransport("smtp");
			t.connect(correoRemitente, passwordRemitente);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();
			
			//JOptionPane.showMessageDialog(null, "Correo enviado!!");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e );
		}

	}
	
	public void enviarCorreoFactura(String contrasena) throws AddressException, MessagingException {

		try {
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);

			String correoRemitente = "aplicaciongym2021@gmail.com";
			String passwordRemitente = "appGYM2021+";
			
			String asunto = "Soda Restaurante";
			String mensaje = "Soda Restaurante le informa que su contraseña es : \n" + contrasena ;

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correoRemitente));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport t = session.getTransport("smtp");
			t.connect(correoRemitente, passwordRemitente);
			t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			t.close();
			
			//JOptionPane.showMessageDialog(null, "Correo enviado!!");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e );
		}

	}
	//props.setProperty("","");
}
