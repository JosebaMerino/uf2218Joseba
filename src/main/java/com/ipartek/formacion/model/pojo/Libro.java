package com.ipartek.formacion.model.pojo;

public class Libro {
	private int id;
	private String nombre;
	private String autor;
	private String imagen;
	private float precio;
	private int descuento;



	public Libro() {
		super();
		this.id = 0;
		this.nombre = "";
		this.autor = "Anonimo";
		this.imagen = "https://images-eu.ssl-images-amazon.com/images/I/51hXV66sRzL.jpg";
		this.precio = 0.0f;
		this.descuento = 0;
	}

	public Libro(int id, String nombre, float precio) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Libro(int id, String nombre, String autor, String imagen, float precio, int descuento) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.imagen = imagen;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float calcularPrecioDescuento() {
		float resul = 0.0f;

		resul = precio * ((100f - descuento) / 100f);

		return resul;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + "]";
	}


}
