package com.correo.sistema.correo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.correo.sistema.correo.model.Emisor;
import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.PaqueteEnviar;
import com.correo.sistema.correo.model.Receptor;
import com.correo.sistema.correo.model.models.PaqueteModel;
import com.correo.sistema.correo.model.models.PaqueteModelCrear;
import com.correo.sistema.correo.repository.EmisorRepository;
import com.correo.sistema.correo.repository.PaqueteRepository;

import com.correo.sistema.correo.repository.ReceptorRepository;

@Service
public class PaqueteService {

	  @PersistenceContext
	  private EntityManager em;
	@Autowired
	PaqueteRepository paqueterepo;
	
	@Autowired
	EmisorRepository emirepo;
	
	@Autowired
	ReceptorRepository recerepo;
	
	public void crear(PaqueteModelCrear paquete1) {
		
		Paquete paquete = new Paquete();
		
		Emisor emisor = new Emisor();
		emisor = emirepo.findById(paquete1.getIdemi()).get();
		
		Receptor receptor = new Receptor();
		receptor = recerepo.findById(paquete1.getIdrece()).get();
		
		paquete.setEmisor(emisor);
		paquete.setReceptor(receptor);
		paquete.setCantidad(paquete1.getCantidad());
		paquete.setNumOrden(paquete1.getNumOrden());
		paquete.setOrigen(paquete1.getOrigen());
		paquete.setPeso(paquete1.getPeso());
		paquete.setPrecio(paquete1.getPrecio());
		paquete.setCorreo(paquete1.getCorreo());
		Calendar fecha = new GregorianCalendar();
		 
		 int año = fecha.get(Calendar.YEAR);
	     int mes = fecha.get(Calendar.MONTH);
	     int dia = fecha.get(Calendar.DAY_OF_MONTH);
	     
	     String FechaLlegada =  dia + "/" + (mes+1) + "/" + año;
		//paquete.setFechaEntrega(paquete1.getFechaEntrega());
		paquete.setFechaLlegada(FechaLlegada);
		
		paqueterepo.save(paquete);
	}
	
	public List<Paquete> ListarPaquetes(){
		
		List<Paquete> paquete = new ArrayList<Paquete>();
		paquete = paqueterepo.findAll();
		
		return paquete;
	}
	public Paquete getId(Long id){
		Paquete paquete = new Paquete();
		paquete = paqueterepo.findById(id).get();
		
		return paquete;
	}
	/*public Stream<Paquete> getForEmi(){
		Paquete emisor = new Paquete();
		
		Stream<Paquete> paquetes;
		paquetes = (emisor.getClass(Paquete)).stream().filter(nombre -> nombre.getEmisor().getNombre() =="Edgar");
		return paquetes;
	}*/
	public void actualizar(PaqueteModel paquete) {
			
			Paquete paqueteAc = new Paquete();
			paqueteAc = paqueterepo.findById(paquete.getIdpaquete()).get();
			
			
			Emisor emisor = new Emisor();
			emisor = emirepo.findById(paquete.getIdemi()).get();
			
			Receptor receptor = new Receptor();
			receptor = recerepo.findById(paquete.getIdrece()).get();
			
			//paqueteAc.setPersona(persona);
			paqueteAc.setEmisor(emisor);
			paqueteAc.setReceptor(receptor);
			paqueteAc.setIdpaquete(paquete.getIdpaquete());
			paqueteAc.setCantidad(paquete.getCantidad());
			paqueteAc.setNumOrden(paquete.getNumOrden());
			paqueteAc.setOrigen(paquete.getOrigen());
			paqueteAc.setPeso(paquete.getPeso());
			paqueteAc.setPrecio(paquete.getPrecio());
			paqueteAc.setFechaEntrega(paquete.getFechaEntrega());
			paqueteAc.setFechaLlegada(paquete.getFechaLlegada());
			paqueterepo.save(paqueteAc);
		}
public void eliminar(Long id) {
		
		Paquete paqueteAc = new Paquete();
		paqueteAc = paqueterepo.findById(id).get();
		paqueterepo.delete(paqueteAc);
	}
public List<Paquete> getForCorreo(String correo){
	return paqueterepo.findByCorreo(correo);
}
public void actualizarEstadoTrue (Long id) {
	Paquete paquete = new Paquete();
	
	paquete = paqueterepo.findById(id).get();
	
	paquete.setEstado(true);
	 Calendar fecha = new GregorianCalendar();
	 
	 int año = fecha.get(Calendar.YEAR);
     int mes = fecha.get(Calendar.MONTH);
     int dia = fecha.get(Calendar.DAY_OF_MONTH);
     
     String FechaFinal =  dia + "/" + (mes+1) + "/" + año;
     paquete.setFechaEntrega(FechaFinal);
     
			 
	paqueterepo.save(paquete);
}
public void actualizarEstadoFalse (Long id) {
Paquete paquete = new Paquete();
	
	paquete = paqueterepo.findById(id).get();
	
	paquete.setEstado(false);
	
	paqueterepo.save(paquete);
}
}
