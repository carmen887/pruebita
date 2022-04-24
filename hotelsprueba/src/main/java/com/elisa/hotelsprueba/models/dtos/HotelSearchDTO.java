package com.elisa.hotelsprueba.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class HotelSearchDTO {

	@NotBlank(message = "Nombre vacio")
	@Size(min=4, max=40)
	private String nombre;

	public HotelSearchDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
