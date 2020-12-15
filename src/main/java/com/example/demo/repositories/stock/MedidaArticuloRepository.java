package com.example.demo.repositories.stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.stock.MedidaArticulo;

@Repository
public interface MedidaArticuloRepository extends JpaRepository<MedidaArticulo, Long> {

	@Override
	@Query(value = "SELECT * FROM medidaarticulo WHERE status = 1", nativeQuery = true)
	public Page<MedidaArticulo> findAll(Pageable page);
}
