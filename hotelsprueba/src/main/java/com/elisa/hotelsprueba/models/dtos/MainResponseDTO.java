package com.elisa.hotelsprueba.models.dtos;

import java.util.List;

public class MainResponseDTO {
	
	private List<String> nombres;

	public MainResponseDTO(List<String> nombres) {
		super();
		this.nombres = nombres;
	}

	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}
	
	
}
