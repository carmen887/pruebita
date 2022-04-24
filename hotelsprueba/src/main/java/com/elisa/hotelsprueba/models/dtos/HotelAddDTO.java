package com.elisa.hotelsprueba.models.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HotelAddDTO {
	
	@NotBlank
	@Size(min=4, max=4)
	private String codigo;
	
	@NotBlank
	@Size(min=4, max=40)
	private String nombre;
	
	@NotBlank
	@Size(min=4, max=40)
	private String direccion;
	
	@NotBlank
	@Size(min=8, max=8)
	private String telefono;
	
	@Min(1)
	@Max(5)
	private Integer categoria;
	
	@Min(1)
	@Max(500)
	private Integer habitaciones;
	
	public HotelAddDTO(String codigo, String nombre, String direccion, String telefono, Integer categoria,
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
