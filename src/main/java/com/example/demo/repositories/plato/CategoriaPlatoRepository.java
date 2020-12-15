package com.example.demo.repositories.plato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.plato.CategoriaPlato;
import com.example.demo.entities.stock.MedidaArticulo;

@Repository
public interface CategoriaPlatoRepository extends JpaRepository<CategoriaPlato, Long> {
	@Override
	@Query(value = "SELECT * FROM categoriaplato WHERE status = 1", nativeQuery = true)
	public Page<CategoriaPlato> findAll(Pageable page);
}
