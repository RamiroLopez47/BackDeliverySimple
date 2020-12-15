package com.example.demo.repositories.persona.domicilio;

import com.example.demo.entities.persona.domicilio.Localidad;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad,Long> {
	
	@Query("select p FROM Localidad p WHERE p.departamento.id=?1")
    List<Localidad> findByDepartamento(long departamentoId, Pageable pagable);
}
