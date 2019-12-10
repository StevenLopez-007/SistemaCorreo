package com.correo.sistema.correo.model.models;

public class PaqueteModel {

	private Long idpaquete;
	
	private Long idrece;
	private Long idemi;
	
	
	private Float precio;
	private String origen;
	private String peso;
	private Integer cantidad;
	private String numOrden;
	private String fechaLlegada;
	private String fechaEntrega;
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public Long getIdpaquete() {
		return idpaquete;
	}
	public void setIdpaquete(Long idpaquete) {
		this.idpaquete = idpaquete;
	}
	
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNumOrden() {
		return numOrden;
	}
	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
	}
	/*public String getNombre() {
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
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}*/
	public Long getIdrece() {
		return idrece;
	}
	public void setIdrece(Long idrece) {
		this.idrece = idrece;
	}
	public Long getIdemi() {
		return idemi;
	}
	public void setIdemi(Long idemi) {
		this.idemi = idemi;
	}
	
	
}
