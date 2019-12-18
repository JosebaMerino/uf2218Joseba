package com.ipartek.formacion.model.pojo;

public class Libro {
	private int id;
	private String nombre;
	private float precio;
	private int descuento;



	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0.0f;
		this.descuento = 0;
	}

	public Libro(int id, String nombre, float precio, int descuento) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + "]";
	}




}
