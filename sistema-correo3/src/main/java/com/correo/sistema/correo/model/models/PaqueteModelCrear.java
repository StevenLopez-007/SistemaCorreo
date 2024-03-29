package com.correo.sistema.correo.model.models;

public class PaqueteModelCrear {
	private Long idrece;
	private Long idemi;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	private Float precio;
	private String origen;
	private String peso;
	private Integer cantidad;
	private String numOrden;
	private String correo;
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
}
