package com.elisa.tallerlogin.models.dtos;

import java.util.List;

public class UserResponseDTO {
	private String nombre;
	private List<String> empleadosN;
	private List<String> empleadosF;
	private List<String> empleadosR;
	
	public UserResponseDTO(String nombre, List<String> empleadosN, List<String> empleadosF, List<String> empleadosR) {
		super();
		this.nombre = nombre;
		this.empleadosN = empleadosN;
		this.empleadosF = empleadosF;
		this.empleadosR = empleadosR;
	}

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<String> getEmpleadosN() {
		return empleadosN;
	}


	public void setEmpleadosN(List<String> empleadosN) {
		this.empleadosN = empleadosN;
	}


	public List<String> getEmpleadosF() {
		return empleadosF;
	}


	public void setEmpleadosF(List<String> empleadosF) {
		this.empleadosF = empleadosF;
	}


	public List<String> getEmpleadosR() {
		return empleadosR;
	}


	public void setEmpleadosR(List<String> empleadosR) {
		this.empleadosR = empleadosR;
	}


	public boolean isPersonCorrect() {
		return !this.nombre.isBlank();
	}
	
}