package com.correo.sistema.correo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table
@Entity
public class Paquete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpaquete;

	/*@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	//@MapsId("idpersona")
	@JoinColumn(name = "id_persona")
	private Persona persona;*/
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_emisor")
	private Emisor emisor;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_receptor")
	private Receptor receptor;
	
	private Float precio;
	private String origen;
	private String peso;
	private Integer cantidad;
	private String numOrden;
	
	/*public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}*/
	public Long getIdpaquete() {
		return idpaquete;
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
}