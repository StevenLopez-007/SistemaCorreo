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

import com.correo.sistema.correo.model.Paquete;
import com.correo.sistema.correo.model.PaqueteEnviar;
import com.correo.sistema.correo.model.models.PaqueteEnviarActualizar;
import com.correo.sistema.correo.model.models.PaqueteEnviarCrearModel;
import com.correo.sistema.correo.model.models.PaqueteModel;
import com.correo.sistema.correo.model.models.PaqueteModelCrear;
import com.correo.sistema.correo.service.PaqueteEnviarService;
import com.correo.sistema.correo.service.PaqueteService;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/api/paqueteEnviar")
public class PaqueteEnviarResource {
	@Autowired
	PaqueteEnviarService paqueteenviarservice;
	
	@PostMapping(value = "/crear",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
public List<PaqueteEnviar> create(@RequestBody final PaqueteEnviarCrearModel paquete1){
	
		paqueteenviarservice.crear(paquete1);
	
	return paqueteenviarservice.ListarPaquetes();
}
	@GetMapping
	public List<PaqueteEnviar> Listar(){
		return paqueteenviarservice.ListarPaquetes();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PaqueteEnviar getForId(Model model,@PathVariable("id") Long id){
		return paqueteenviarservice.getId(id);
	}
	@PutMapping(value = "/actualizar",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PaqueteEnviar> actualizar(@RequestBody final PaqueteEnviarActualizar paquete){
		
		paqueteenviarservice.actualizar(paquete);
		
		return paqueteenviarservice.ListarPaquetes();
	}
	@DeleteMapping(value = "/eliminar/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<PaqueteEnviar> actualizar(Model model,@PathVariable("id") Long id){
		
		paqueteenviarservice.eliminar(id);
		
		return paqueteenviarservice.ListarPaquetes();
	}
	@RequestMapping(value ="/correo/{correoEnviar}",method=RequestMethod.GET)
    public List<PaqueteEnviar> findByCorreo(@PathVariable String correoEnviar) {
        return paqueteenviarservice.getForCorreo(correoEnviar);
    }
	
	@PutMapping(value = "/actualizarEstadoEnviado/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarEstadoEnviado(@PathVariable("id") Long id){
		
		paqueteenviarservice.actualizarEstadoEnviado(id);
		
	}
	@PutMapping(value = "/actualizarEstadoLlegada/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarEstadoLlegada(@PathVariable("id") Long id){
		
		paqueteenviarservice.actualizarEstadoLlegada(id);
		
	}
	@RequestMapping(value ="/numOrdenEnviar/{numOrdenEnviar}",method=RequestMethod.GET)
    public List<PaqueteEnviar> findBynumOrdenEnviar(@PathVariable String numOrdenEnviar) {
        return paqueteenviarservice.getFornumOrdenEnviar(numOrdenEnviar);
    }
	
}
