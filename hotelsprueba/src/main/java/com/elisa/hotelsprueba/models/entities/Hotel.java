package com.elisa.hotelsprueba.models.entities;

public class Hotel {
	
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private Integer categoria;
	private Integer habitaciones;
	
	public Hotel(String codigo, String nombre, String direccion, String telefono, Integer categoria,
			Integer habitaciones) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.categoria = categoria;
		this.habitaciones = habitaciones;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Integer getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
	public Integer getHabitaciones() {
		return habitaciones;
	}
	
	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	
}
