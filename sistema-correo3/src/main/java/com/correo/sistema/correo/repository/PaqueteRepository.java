package com.correo.sistema.correo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.correo.sistema.correo.model.Paquete;
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
	 public List<Paquete> findByCorreo(String correo);
}
