
package Models;



public class Factura {
	
	//////////////////////////////////////////
	//// Para agregar producto a carrito  ////
	//////////////////////////////////////////
	
	private int idFactura;
	private int idUsuario;
	private int total;
	private int iva;
	private int subtotal;
	private String fecha;
	private int numerofacturas;
	

	

	public Factura() {
	}

	public Factura(int idUsuario, int total, int iva, int subtotal, String fecha,int numerofacturas) {
		this.idUsuario = idUsuario;
		this.total = total;
		this.iva = iva;
		this.subtotal = subtotal;
		this.fecha = fecha;
		this.numerofacturas = numerofacturas;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumerofacturas() {
		return numerofacturas;
	}

	public void setNumerofacturas(int numerofacturas) {
		this.numerofacturas = numerofacturas;
	}


	
}
