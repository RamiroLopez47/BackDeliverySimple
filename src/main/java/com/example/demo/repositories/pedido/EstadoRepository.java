package com.example.demo.repositories.pedido;

import com.example.demo.entities.pedido.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	@Query("SELECT e FROM Estado e WHERE e.denominacion =?1")
	Estado findByDenominacion(String termino);
}
