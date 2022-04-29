package com.elisa.tallerlogin.models.dtos;

public class UserSearchDTO {

	private String codigo;
	private String contrasena;
	
	public UserSearchDTO(String codigo, String contrasena) {
		super();
		this.codigo = codigo;
		this.contrasena = contrasena;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
