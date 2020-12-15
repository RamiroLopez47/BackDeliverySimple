package com.example.demo.repositories.persona.domicilio;

import com.example.demo.entities.persona.domicilio.Domicilio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
	@Override
	@Query(value = "SELECT * FROM domicilio WHERE status = 1", nativeQuery = true)
	public Page<Domicilio> findAll(Pageable page);
}
