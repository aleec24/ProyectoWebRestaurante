
package Models;


public class Comentario {
	
	//-----------
	//Variables
	
	//************
	// Int
	
	private  int idComentario;
	private  int telefono;
	
	//************
	// String
	
	private  String nombre;
	private  String correo;
	private  String comentario;

	//-----------
	//Constructor
	
	public Comentario() {
	}

	public Comentario(int telefono, String nombre, String correo, String comentario) {
		this.telefono = telefono;
		this.nombre = nombre;
		this.correo = correo;
		this.comentario = comentario;
	}

	//---------------------
	//Getters and Setters
	
	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
	
	
	
}
