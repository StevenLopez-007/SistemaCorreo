package com.correo.sistema.correo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.correo.sistema.correo.model.Receptor;

import com.correo.sistema.correo.model.models.Receptor.ReceptorModelActualizar;
import com.correo.sistema.correo.model.models.Receptor.ReceptorModelCrear;
import com.correo.sistema.correo.repository.ReceptorRepository;

@Service
public class ReceptorService {

	@Autowired
	ReceptorRepository recerepo;
	
	public void crear(ReceptorModelCrear receptor1) {
		
		Receptor receptor = new Receptor();
		
		receptor.setCodigoPostal(receptor1.getCodigoPostal());
		receptor.setDireccion(receptor1.getDireccion());
		receptor.setDUI(receptor1.getDUI());
		receptor.setNombre(receptor1.getNombre());
		receptor.setTelefono(receptor1.getTelefono());
		
		recerepo.save(receptor);
		
	}
	
	public List<Receptor> listarReceptores (){
		return recerepo.findAll();
	}
	public void actualizar(ReceptorModelActualizar receptor1) {
		Receptor receptor = new Receptor();
		
		receptor.setIdpersona(receptor1.getIdrece());
		receptor.setCodigoPostal(receptor1.getCodigoPostal());
		receptor.setDireccion(receptor1.getDireccion());
		receptor.setDUI(receptor1.getDUI());
		receptor.setNombre(receptor1.getNombre());
		receptor.setTelefono(receptor1.getTelefono());
		
		recerepo.save(receptor);
	}
	public Receptor getId(Long id){
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(id).get();
		
		return receptor;
	}
	public void eliminar(Long id) {
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(id).get();
		
		recerepo.delete(receptor);
	}
}
