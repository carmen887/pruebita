package com.elisa.tallerlogin.models.entities;

import java.util.Date;

public class User {
	private String codigo;
	private String nombre;
	private String fecha;
	private String estado;
	private String rol;
	private String contrasena;
	private Integer fallas;
	private Integer bono;
	
	public User(String codigo, String nombre, String fecha, String estado, String rol, String contrasena,
			Integer fallas, Integer bono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.estado = estado;
		this.rol = rol;
		this.contrasena = contrasena;
		this.fallas = fallas;
		this.bono = bono;
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
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Integer getFallas() {
		return fallas;
	}
	
	public void setFallas(Integer fallas) {
		this.fallas = fallas;
	}
	
	public Integer getBono() {
		return bono;
	}
	
	public void setBono(Integer bono) {
		this.bono = bono;
	}
}
