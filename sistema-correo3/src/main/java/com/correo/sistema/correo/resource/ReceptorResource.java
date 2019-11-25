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

import com.correo.sistema.correo.model.Receptor;

import com.correo.sistema.correo.model.models.Receptor.ReceptorModelActualizar;
import com.correo.sistema.correo.model.models.Receptor.ReceptorModelCrear;

import com.correo.sistema.correo.service.ReceptorService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/Receptor")
public class ReceptorResource {
	@Autowired
	ReceptorService receptorservice;
	
	@PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
public List<Receptor> create(@RequestBody final ReceptorModelCrear receptor){
	
		receptorservice.crear(receptor);
	
	return receptorservice.listarReceptores();
}
	@GetMapping
	public List<Receptor> Listar(){
		return receptorservice.listarReceptores();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Receptor getForId(Model model,@PathVariable("id") Long id){
		return receptorservice.getId(id);
	}
	@PutMapping(value = "/actualizar",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Receptor> actualizar(@RequestBody final ReceptorModelActualizar receptor){
		
		receptorservice.actualizar(receptor);
		
		return receptorservice.listarReceptores();
	}
	@DeleteMapping(value = "/eliminar/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Receptor> eliminar(Model model,@PathVariable("id") Long id){
		
		receptorservice.eliminar(id);
		
		return receptorservice.listarReceptores();
	}
}
