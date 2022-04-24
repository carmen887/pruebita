package com.elisa.hotelsprueba.models.dtos;

public class HotelResponseDTO {

	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	private Integer categoria;
	private Integer habitaciones;
	
	public HotelResponseDTO(String codigo, String nombre, String direccion, String telefono, Integer categoria,
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
	
	public boolean isCodeValid() {
		return !this.codigo.isBlank();
	}
	
	public boolean isNameValid() {
		return !this.nombre.isBlank();
	}
	
	public boolean isDirValid() {
		return !this.direccion.isBlank();
	}
	
	public boolean isTelValid() {
		return !this.telefono.isBlank();
	}
	
	public boolean isCatValid() {
		return !this.categoria.equals(0);
	}
	
	public boolean isHabValid() {
		return !this.habitaciones.equals(0);
	}
}
