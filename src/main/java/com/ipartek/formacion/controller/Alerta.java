package com.ipartek.formacion.controller;

public class Alerta {
	public static final String TIPO_SUCCESS = "success";
	public static final String TIPO_WARNING = "warning";

	private String tipo;
	private String titulo;
	private String descripcion;


	public Alerta(String tipo, String titulo, String descripcion) {
		super();
		this.tipo = tipo;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
