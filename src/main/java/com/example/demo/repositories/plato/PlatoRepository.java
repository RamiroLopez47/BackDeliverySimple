package com.example.demo.repositories.plato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.plato.Plato;
import com.example.demo.entities.stock.MedidaArticulo;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    @Query("select p FROM Plato p WHERE p.categoriaPlato.denominacion=?1 AND status = 1")
    List<Plato> findByCategoria(String categoria, Pageable pagable);

    @Query (value="WITH subconsulta AS (SELECT detalle_pedido_plato,COUNT(detalle_pedido_plato) AS total FROM detalle_pedido WHERE detalle_pedido_pedido IN (SELECT id FROM pedido WHERE fecha BETWEEN ?1 AND ?2 )\r\n" + 
			"GROUP BY detalle_pedido_plato) SELECT * FROM plato INNER JOIN subconsulta S ON plato.id = S.detalle_pedido_plato ORDER BY S.total DESC",nativeQuery = true)
	List <Plato> topPlatos(String fechaInicio, String fechaFin);
    
    @Override
	@Query(value = "SELECT * FROM plato WHERE status = 1", nativeQuery = true)
	public Page<Plato> findAll(Pageable page);
}
