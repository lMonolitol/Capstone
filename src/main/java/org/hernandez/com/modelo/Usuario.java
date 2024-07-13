package org.hernandez.com.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario" )
public class Usuario {
	@Id
	private int id;
	private String nombre;
	private String apellido;
	public String correo;
	private String contraseña;
	private List<Item> carrito = new ArrayList<Item>();
	public Usuario(int id, String nombre, String apellido, String correo, String contraseña) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	public Usuario() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public List<Item> getCarrito() {
		return carrito;
	}
	public void setCarrito(List<Item> carrito) {
		this.carrito = carrito;
	}
	
	
	
}
