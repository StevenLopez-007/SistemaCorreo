package com.correo.sistema.correo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.correo.sistema.correo.model.PaqueteEnviar;

public interface PaqueteEnviarRepository extends JpaRepository<PaqueteEnviar,Long> {
	
	List<PaqueteEnviar> findByCorreo (String correo);
}
