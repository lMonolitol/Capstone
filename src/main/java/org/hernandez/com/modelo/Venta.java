package org.hernandez.com.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Venta" )

public class Venta {
	@Id
	private int id;
	private String fecha;
	private Double monto;
	public Venta(int id, String fecha, Double monto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.monto = monto;
	}
	public Venta() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
}
