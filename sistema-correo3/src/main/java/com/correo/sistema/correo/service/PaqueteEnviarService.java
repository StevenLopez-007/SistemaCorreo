package com.correo.sistema.correo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		PaqueteEnviar paquete2 = new PaqueteEnviar();
		
		Emisor emisor = new Emisor();
		emisor = emirepo.findById(paquete1.getIdreme()).get();
		
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(paquete1.getIdrece()).get();
		
		paquete2.setCantidadEnviar(paquete1.getCantidadEnviar());
		paquete2.setCorreoEnviar(paquete1.getCorreoEnviar());
		paquete2.setDestinoEnviar(paquete1.getDestinoEnviar());
		paquete2.setEmisor(emisor);
		paquete2.setFechaEnviar(paquete1.getFechaEnviar());
		paquete2.setFechaLlegada(paquete1.getFechaLlegada());
		paquete2.setNumOrdenEnviar(paquete1.getNumOrdenEnviar());
		paquete2.setPesoEnviar(paquete1.getPesoEnviar());
		paquete2.setPrecioEnviar(paquete1.getPrecioEnviar());
		paquete2.setReceptor(receptor);
		
		paqueteenviarepo.save(paquete2);
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
		paqueteAc.setFechaEnviar(paquete.getFechaEnviar());
		paqueteAc.setFechaLlegada(paquete.getFechaLlegada());
		paqueteenviarepo.save(paqueteAc);
	}

	public void eliminar(Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		paquete = paqueteenviarepo.findById(id).get();
		
		paqueteenviarepo.delete(paquete);
		
	}
	
	public List<PaqueteEnviar> getForCorreo (String correoEnviar){
		
		return paqueteenviarepo.findByCorreoEnviar(correoEnviar);
		 
	}
	
	public void actualizarEstadoTrue (Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		
		paquete = paqueteenviarepo.findById(id).get();
		
		paquete.setEstado(true);
		
		paqueteenviarepo.save(paquete);
	}
	public void actualizarEstadoFalse (Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		
		paquete = paqueteenviarepo.findById(id).get();
		
		paquete.setEstado(false);
		
		paqueteenviarepo.save(paquete);
	}
}
