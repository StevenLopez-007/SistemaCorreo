package com.correo.sistema.correo.resource;

import java.util.List;
import java.util.stream.Stream;

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

import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.models.PaqueteModel;
import com.correo.sistema.correo.model.models.PaqueteModelCrear;
import com.correo.sistema.correo.service.PaqueteService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/paquete")
public class PaqueteResource {
	@Autowired
	PaqueteService paqueteservice;
	
	@PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
public List<Paquete> create(@RequestBody final PaqueteModelCrear paquete){
	
		paqueteservice.crear(paquete);
	
	return paqueteservice.ListarPaquetes();
}
	@GetMapping
	public List<Paquete> Listar(){
		return paqueteservice.ListarPaquetes();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Paquete getForId(Model model,@PathVariable("id") Long id){
		return paqueteservice.getId(id);
	}
	@PutMapping(value = "/actualizar",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Paquete> actualizar(@RequestBody final PaqueteModel paquete){
		
		paqueteservice.actualizar(paquete);
		
		return paqueteservice.ListarPaquetes();
	}
	@DeleteMapping(value = "/eliminar/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Paquete> actualizar(Model model,@PathVariable("id") Long id){
		
		paqueteservice.eliminar(id);
		
		return paqueteservice.ListarPaquetes();
	}
	
}
