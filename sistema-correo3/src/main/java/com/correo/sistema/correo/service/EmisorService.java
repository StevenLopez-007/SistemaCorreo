package com.correo.sistema.correo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correo.sistema.correo.model.Emisor;
import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.models.Emisor.EmisorActualizarModel;
import com.correo.sistema.correo.model.models.Emisor.EmisorModelCrear;
import com.correo.sistema.correo.repository.EmisorRepository;

@Service
public class EmisorService {
	@Autowired
	EmisorRepository emirepo;
	
	
	public void crear(EmisorModelCrear emisor1) {
		
		Emisor emisor = new Emisor();
		
		emisor.setDireccion(emisor1.getDireccion());
		emisor.setDUI(emisor1.getDUI());
		emisor.setCodigoPostal(emisor1.getCodigoPostal());
		emisor.setNombre(emisor1.getNombre());
		emisor.setTelefono(emisor1.getTelefono());
		
		emirepo.save(emisor);
	}
	public List<Emisor> ListarEmisores (){
		return emirepo.findAll();
	}
	
	public void actualizar(EmisorActualizarModel emisor1) {
		Emisor emisor = new Emisor();
		
		emisor.setIdpersona(emisor1.getIdemi());
		emisor.setCodigoPostal(emisor1.getCodigoPostal());
		emisor.setDireccion(emisor1.getDireccion());
		emisor.setDUI(emisor1.getDUI());
		emisor.setNombre(emisor1.getNombre());
		emisor.setTelefono(emisor1.getTelefono());
		
		emirepo.save(emisor);
	}
	
	public Emisor getId(Long id){
		Emisor emisor = new Emisor();
		emisor = emirepo.findById(id).get();
		
		return emisor;
	}
	public void eliminar(Long id) {
		emirepo.deleteById(id);		
	}
}
