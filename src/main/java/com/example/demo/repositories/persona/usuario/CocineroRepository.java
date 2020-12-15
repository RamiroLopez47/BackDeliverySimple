package com.example.demo.repositories.persona.usuario;

import com.example.demo.entities.persona.usuario.Cocinero;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CocineroRepository extends JpaRepository<Cocinero, Long> {

	Cocinero findByEmail(String email);

	@Query("SELECT c FROM Cocinero c WHERE c.estaActivo = TRUE ")
	List<Cocinero> cocinerosActivos();
}