package com.correo.sistema.correo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		//paquete2.setFechaEnviar(paquete1.getFechaEnviar());
		//paquete2.setFechaLlegada(paquete1.getFechaLlegada());
		 Calendar fecha = new GregorianCalendar();
		 
		 int año = fecha.get(Calendar.YEAR);
	     int mes = fecha.get(Calendar.MONTH);
	     int dia = fecha.get(Calendar.DAY_OF_MONTH);
	     
	     String FechaRecibido =  dia + "/" + (mes+1) + "/" + año;
		paquete2.setFechaRecibido(FechaRecibido);
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
	
	public void actualizarEstadoEnviado (Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		Calendar fecha = new GregorianCalendar();
		 
		 int año = fecha.get(Calendar.YEAR);
	     int mes = fecha.get(Calendar.MONTH);
	     int dia = fecha.get(Calendar.DAY_OF_MONTH);
	     
	     String FechaEnviado =  dia + "/" + (mes+1) + "/" + año;
		
		paquete = paqueteenviarepo.findById(id).get();
		
		paquete.setEstado("En transito");
		paquete.setFechaEnviar(FechaEnviado);
		
		paqueteenviarepo.save(paquete);
	}
	public void actualizarEstadoLlegada (Long id) {
		PaqueteEnviar paquete = new PaqueteEnviar();
		Calendar fecha = new GregorianCalendar();
		 
		 int año = fecha.get(Calendar.YEAR);
	     int mes = fecha.get(Calendar.MONTH);
	     int dia = fecha.get(Calendar.DAY_OF_MONTH);
	     
	     String FechaLlegada =  dia + "/" + (mes+1) + "/" + año;
		paquete = paqueteenviarepo.findById(id).get();
		
		if(paquete.getEstado()!="Recibido")
		{
			paquete.setEstado("Entregado");
			paquete.setFechaLlegada(FechaLlegada);
			
			paqueteenviarepo.save(paquete);
		}
		
	}
	
public List<PaqueteEnviar> getFornumOrdenEnviar (String numOrdenEnviar){
		
		return paqueteenviarepo.findByNumOrdenEnviar(numOrdenEnviar);
		 
	}
}
