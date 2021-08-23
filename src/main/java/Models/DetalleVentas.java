
package Models;



public class DetalleVentas {
	
	//////////////////////////////////////////
	//// Para agregar producto a carrito  ////
	//////////////////////////////////////////
	
	private int idDetalleVentas;
	private int idProducto;
	private int idFactura;
	private int cantidad;
	private int precioUnitario;
	
	

	public DetalleVentas() {
	}

	public DetalleVentas(int idProducto, int idFactura, int cantidad, int precioUnitario) {
		this.idProducto = idProducto;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public DetalleVentas(int idDetalleVentas, int idProducto, int idFactura, int cantidad, int precioUnitario) {
		this.idDetalleVentas = idDetalleVentas;
		this.idProducto = idProducto;
		this.idFactura = idFactura;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public int getIdDetalleVentas() {
		return idDetalleVentas;
	}

	public void setIdDetalleVentas(int idDetalleVentas) {
		this.idDetalleVentas = idDetalleVentas;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	
}
