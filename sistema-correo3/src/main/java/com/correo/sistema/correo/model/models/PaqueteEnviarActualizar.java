package com.correo.sistema.correo.model.models;

public class PaqueteEnviarActualizar {
	
	private Long idPaquete;
	private Long idreme;
	private Long idrece;
	private Float precioEnviar;
	private String destinoEnviar;
	private String pesoEnviar;
	private Integer cantidadEnviar;
	private String numOrdenEnviar;
	
	public Long getIdreme() {
		return idreme;
	}
	public void setIdreme(Long idreme) {
		this.idreme = idreme;
	}
	public Long getIdrece() {
		return idrece;
	}
	public void setIdrece(Long idrece) {
		this.idrece = idrece;
	}
	public Float getPrecioEnviar() {
		return precioEnviar;
	}
	public void setPrecioEnviar(Float precioEnviar) {
		this.precioEnviar = precioEnviar;
	}
	public String getDestinoEnviar() {
		return destinoEnviar;
	}
	public void setDestinoEnviar(String destinoEnviar) {
		this.destinoEnviar = destinoEnviar;
	}
	public String getPesoEnviar() {
		return pesoEnviar;
	}
	public void setPesoEnviar(String pesoEnviar) {
		this.pesoEnviar = pesoEnviar;
	}
	public Integer getCantidadEnviar() {
		return cantidadEnviar;
	}
	public void setCantidadEnviar(Integer cantidadEnviar) {
		this.cantidadEnviar = cantidadEnviar;
	}
	public String getNumOrdenEnviar() {
		return numOrdenEnviar;
	}
	public void setNumOrdenEnviar(String numOrdenEnviar) {
		this.numOrdenEnviar = numOrdenEnviar;
	}
	public String getFechaEnviar() {
		return fechaEnviar;
	}
	public void setFechaEnviar(String fechaEnviar) {
		this.fechaEnviar = fechaEnviar;
	}
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public Long getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(Long idPaquete) {
		this.idPaquete = idPaquete;
	}
	private String fechaEnviar;
	private String fechaLlegada;
}
