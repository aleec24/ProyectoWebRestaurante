
package Models;


public class CarritoProducto {
	
		
	
	///////////////////////
	//// Para carrito  ////
	///////////////////////
	
	private int idProducto;
	private String nombreProducto;
	private int cantidadUni;
	private int precio;
	private String nombreImagen;
	//--
	private int precioTotal;
	private int unidadesTotal;
	
	//-----------
	//Constructor
	
	public CarritoProducto() {
	}

	
	public CarritoProducto(String nombreProducto, int cantidadUni, int precio, String nombreImagen, int idProducto) {
		this.nombreProducto = nombreProducto;
		this.cantidadUni = cantidadUni;
		this.precio = precio;
		this.nombreImagen = nombreImagen;
		this.idProducto = idProducto;
	}

	public CarritoProducto(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public CarritoProducto(int idProducto, int cantidadUni, int precioTotal) {
		this.idProducto = idProducto;
		this.cantidadUni = cantidadUni;
		this.precioTotal = precioTotal;
	}
	
	public CarritoProducto(String nombreProducto,int idProducto, int cantidadUni, int precioTotal) {
		this.nombreProducto = nombreProducto;
		this.idProducto = idProducto;
		this.cantidadUni = cantidadUni;
		this.precioTotal = precioTotal;
	}
	
	//---------------------
	//Getters and Setters
	

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getUnidadesTotal() {
		return unidadesTotal;
	}

	public void setUnidadesTotal(int unidadesTotal) {
		this.unidadesTotal = unidadesTotal;
	}
	
	
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

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	
	
	
	
	
}
