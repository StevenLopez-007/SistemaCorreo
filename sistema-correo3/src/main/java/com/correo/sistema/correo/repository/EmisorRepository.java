package com.correo.sistema.correo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.correo.sistema.correo.model.Emisor;
public interface EmisorRepository extends JpaRepository<Emisor,Long>{

	
}
