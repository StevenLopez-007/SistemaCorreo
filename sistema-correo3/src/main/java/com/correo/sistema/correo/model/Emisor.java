package com.correo.sistema.correo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Emisor {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
	private List<Paquete> paquete = new ArrayList<Paquete>();
	
	public List<Paquete> getPaquete() {
		return paquete;
	}
	public void setPaquete(List<Paquete> paquete) {
		this.paquete = paquete;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emisor")
	private List<PaqueteEnviar> paqueteEnviar = new ArrayList<PaqueteEnviar>();

	public Emisor() {}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_emisor")
	private Long idemisor;
	
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String telefono;
	private String DUI;
	
	
	public Long getIdpersona() {
		return idemisor;
	}
	public void setIdpersona(Long idemisor) {
		this.idemisor = idemisor;
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
	public List<PaqueteEnviar> getPaqueteEnviar() {
		return paqueteEnviar;
	}
	public void setPaqueteEnviar(List<PaqueteEnviar> paqueteEnviar) {
		this.paqueteEnviar = paqueteEnviar;
	}
}
