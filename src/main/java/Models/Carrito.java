
package Models;


public class Carrito {
	
	//-----------
	//Variables
	
	//************
	// Int
	
	private  int idCarrito;
	private  int idUsuario;
	private  int idProducto;
	private  int carritoActivo;
	private  int cantidadProducto;

	
	//************
	// String
	
	private  String estadoCarrito;
	private  String estadoCompra;
	
	

	//-----------
	//Constructor
	
	public Carrito() {
	}

	public Carrito(int idUsuario, int idProducto, String estadoCarrito) {
		this.idUsuario = idUsuario;
		this.idProducto = idProducto;
		this.estadoCarrito = estadoCarrito;
	}

	public Carrito(int idCarrito, int idUsuario, String estadoCarrito, int carritoActivo) {
		this.idCarrito = idCarrito;
		this.idUsuario = idUsuario;
		this.carritoActivo = carritoActivo;
		this.estadoCarrito = estadoCarrito;
	}


	
	

	public Carrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	

	//---------------------
	//Getters and Setters

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getEstadoCarrito() {
		return estadoCarrito;
	}

	public void setEstadoCarrito(String estadoCarrito) {
		this.estadoCarrito = estadoCarrito;
	}

	public String getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}

	public int getCarritoActivo() {
		return carritoActivo;
	}

	public void setCarritoActivo(int carritoActivo) {
		this.carritoActivo = carritoActivo;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	
}
