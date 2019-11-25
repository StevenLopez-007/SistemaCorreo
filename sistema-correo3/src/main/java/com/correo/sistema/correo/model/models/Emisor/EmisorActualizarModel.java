package com.correo.sistema.correo.model.models.Emisor;

public class EmisorActualizarModel {
	private Long idemi;
	
	public Long getIdemi() {
		return idemi;
	}
	public void setIdemi(Long idemi) {
		this.idemi = idemi;
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
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDUI() {
		return DUI;
	}
	public void setDUI(String dUI) {
		DUI = dUI;
	}
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String telefono;
	private String DUI;
	
}
