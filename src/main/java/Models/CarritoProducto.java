
package Models;


public class CarritoProducto {
	
		
	
	///////////////////////
	//// Para carrito  ////
	///////////////////////
	
	private String nombreProducto;
	private int cantidadUni;
	private int precio;
	private String nombreImagen;
	
	//-----------
	//Constructor
	
	public CarritoProducto() {
	}

	

	public CarritoProducto(String nombreProducto, int cantidadUni, int precio, String nombreImagen) {
		this.nombreProducto = nombreProducto;
		this.cantidadUni = cantidadUni;
		this.precio = precio;
		this.nombreImagen = nombreImagen;
	}
	
	
	

	//---------------------
	//Getters and Setters

	

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombre(String nombre) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidadUni() {
		return cantidadUni;
	}

	public void setCantidadUni(int cantidadUni) {
		this.cantidadUni = cantidadUni;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}
	
	
	
	
	
	
}
