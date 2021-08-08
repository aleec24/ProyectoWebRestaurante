
package Models;

import java.io.File;
import java.nio.file.Files;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Producto {
	
	//-----------
	//Variables
	
	//************
	// Int
	
	private  int idProducto;
	private  int codigo;
	private  int precio;
	private  int stock;
	private  int cod;
	
	//************
	// String
	
	private  String nombre;
	private  String estado;
	private  String descripcion;
	private  String nombreImagen;

	
	
	//-----------
	//Constructor
	
	public Producto() {
	}

	public Producto(int codigo, int precio, int stock, String nombre, String estado, String descripcion) {
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public Producto(int codigo,String nombre ,int precio , String estado, String descripcion,String nombreImagen) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
		this.nombreImagen = nombreImagen;
	}

	public Producto(int codigo,String nombre ,int precio , String estado, String descripcion) {
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	//---------------------
	//Getters and Setters

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
	
}
