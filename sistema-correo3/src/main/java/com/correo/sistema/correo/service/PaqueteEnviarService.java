package com.correo.sistema.correo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correo.sistema.correo.model.Emisor;
import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.PaqueteEnviar;
import com.correo.sistema.correo.model.Receptor;
import com.correo.sistema.correo.model.models.PaqueteEnviarActualizar;
import com.correo.sistema.correo.model.models.PaqueteEnviarCrearModel;
import com.correo.sistema.correo.model.models.PaqueteModel;
import com.correo.sistema.correo.repository.EmisorRepository;
import com.correo.sistema.correo.repository.PaqueteEnviarRepository;
import com.correo.sistema.correo.repository.ReceptorRepository;

@Service
public class PaqueteEnviarService {

	@Autowired
	PaqueteEnviarRepository paqueteenviarepo;
	
	@Autowired
	EmisorRepository emirepo;
	
	@Autowired
	ReceptorRepository recerepo;
	
	public void crear (PaqueteEnviarCrearModel paquete1) {
		
		PaqueteEnviar paquete = new PaqueteEnviar();
		
		Emisor emisor = new Emisor();
		emisor = emirepo.findById(paquete1.getIdreme()).get();
		
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(paquete1.getIdrece()).get();
		
		paquete.setCantidadEnviar(paquete1.getCantidadEnviar());
		paquete.setCorreoEnviar(paquete1.getCorreoEnviar());
		paquete.setDestinoEnviar(paquete1.getDestinoEnviar());
		paquete.setEmisor(emisor);
		paquete.setFechaEnviar(paquete1.getFechaEnviar());
		paquete.setFechaLlegada(paquete1.getFechaLlegada());
		paquete.setNumOrdenEnviar(paquete1.getNumOrdenEnviar());
		paquete.setPesoEnviar(paquete1.getPesoEnviar());
		paquete.setPrecioEnviar(paquete1.getPrecioEnviar());
		paquete.setReceptor(receptor);
		
	}
	
	public List<PaqueteEnviar> ListarPaquetes(){
		return paqueteenviarepo.findAll();
	}
	public PaqueteEnviar getId(Long id){
		PaqueteEnviar paquete = new PaqueteEnviar();
		paquete = paqueteenviarepo.findById(id).get();
		
		return paquete;
	}
	
	public void actualizar(PaqueteEnviarActualizar paquete) {
		
		PaqueteEnviar paqueteAc = new PaqueteEnviar();
		paqueteAc = paqueteenviarepo.findById(paquete.getIdPaquete()).get();
		
		
		Emisor emisor = new Emisor();
		emisor = emirepo.findById(paquete.getIdreme()).get();
		
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(paquete.getIdrece()).get();
		
		//paqueteAc.setPersona(persona);
		paqueteAc.setEmisor(emisor);
		paqueteAc.setReceptor(receptor);
		paqueteAc.setIdpaqueteEnviar(paquete.getIdPaquete());
		paqueteAc.setCantidadEnviar(paquete.getCantidadEnviar());
		paqueteAc.setNumOrdenEnviar(paquete.getNumOrdenEnviar());
		paqueteAc.setDestinoEnviar(paquete.getDestinoEnviar());
		paqueteAc.setPesoEnviar(paquete.getPesoEnviar());
		paqueteAc.setPrecioEnviar(paquete.getPrecioEnviar());
		paqueteenviarepo.save(paqueteAc);
	}

	public void eliminar(Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		paquete = paqueteenviarepo.findById(id).get();
		
		paqueteenviarepo.delete(paquete);
		
	}
	
	public List<PaqueteEnviar> getForCorreo (String correo){
		
		return paqueteenviarepo.findByCorreo(correo);
		 
	}
}
