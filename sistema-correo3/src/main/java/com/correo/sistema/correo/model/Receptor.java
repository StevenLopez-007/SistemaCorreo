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

@Entity
public class Receptor  {
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receptor")
	private List<Paquete> paquete = new ArrayList<Paquete>();
	
	public List<Paquete> getPaquete() {
		return paquete;
	}
	public void setPaquete(List<Paquete> paquete) {
		this.paquete = paquete;
	}
public Receptor() {}


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_receptor")
private Long idreceptor;

private String nombre;
private String direccion;
private String codigoPostal;
private String telefono;
private String DUI;



public Long getIdpersona() {
	return idreceptor;
}
public void setIdpersona(Long idreceptor) {
	this.idreceptor = idreceptor;
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
	
}
