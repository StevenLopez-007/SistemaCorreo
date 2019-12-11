package com.correo.sistema.correo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PaqueteEnviar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpaqueteEnviar;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_emisor")
	private Emisor emisor;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_receptor")
	private Receptor receptor;
	
	private Float precioEnviar;
	private String destinoEnviar;
	private String pesoEnviar;
	private Integer cantidadEnviar;
	private String numOrdenEnviar;
	private String correoEnviar;
	private String fechaEnviar;
	private String fechaRecibido;
	public String getFechaRecibido() {
		return fechaRecibido;
	}
	public void setFechaRecibido(String fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}
	private String fechaLlegada;
	private String estado = "Recibido";
	
	public Long getIdpaqueteEnviar() {
		return idpaqueteEnviar;
	}
	public void setIdpaqueteEnviar(Long idpaqueteEnviar) {
		this.idpaqueteEnviar = idpaqueteEnviar;
	}
	public Emisor getEmisor() {
		return emisor;
	}
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
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
	public String getCorreoEnviar() {
		return correoEnviar;
	}
	public void setCorreoEnviar(String correoEnviar) {
		this.correoEnviar = correoEnviar;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
