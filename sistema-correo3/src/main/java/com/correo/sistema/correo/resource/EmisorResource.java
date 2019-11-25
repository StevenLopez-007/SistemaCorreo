package com.correo.sistema.correo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.correo.sistema.correo.model.Emisor;
import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.models.PaqueteModel;
import com.correo.sistema.correo.model.models.PaqueteModelCrear;
import com.correo.sistema.correo.model.models.Emisor.EmisorActualizarModel;
import com.correo.sistema.correo.model.models.Emisor.EmisorModelCrear;
import com.correo.sistema.correo.service.EmisorService;
import com.correo.sistema.correo.service.PaqueteService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/Emisor")
public class EmisorResource {
	@Autowired
	EmisorService emisorservice;
	
	@PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
public List<Emisor> create(@RequestBody final EmisorModelCrear emisor){
	
		emisorservice.crear(emisor);
	
	return emisorservice.ListarEmisores();
}
	@GetMapping
	public List<Emisor> Listar(){
		return emisorservice.ListarEmisores();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Emisor getForId(Model model,@PathVariable("id") Long id){
		return emisorservice.getId(id);
	}
	@PutMapping(value = "/actualizar",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Emisor> actualizar(@RequestBody final EmisorActualizarModel emisor){
		
		emisorservice.actualizar(emisor);
		
		return emisorservice.ListarEmisores();
	}
	@DeleteMapping(value = "/eliminar/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Emisor> eliminar(Model model,@PathVariable("id") Long id){
		
		emisorservice.eliminar(id);
		
		return emisorservice.ListarEmisores();
	}
}
