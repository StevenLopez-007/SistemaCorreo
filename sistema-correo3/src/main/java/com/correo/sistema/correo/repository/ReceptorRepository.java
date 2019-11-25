package com.correo.sistema.correo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.correo.sistema.correo.model.Receptor;

public interface ReceptorRepository extends JpaRepository<Receptor,Long> {

}
