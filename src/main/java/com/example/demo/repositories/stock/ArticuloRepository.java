package com.example.demo.repositories.stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.entities.stock.Articulo;
import com.example.demo.entities.stock.MedidaArticulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    @Query("select a FROM Articulo a WHERE a.categoriaArticulo.denominacion=?1 AND status = 1")
    List<Articulo> findByCategoria(String categoria);
    
    @Query(value="SELECT * FROM articulo WHERE stock_actual < stock_min AND status = 1",nativeQuery = true)
	List <Articulo> stockBajo();
    
    @Query(value="SELECT * FROM articulo WHERE es_insumo = FALSE AND status = 1", nativeQuery=true)
    List <Articulo> getProductoReventa();
    
    @Query(value="SELECT * FROM articulo WHERE es_insumo = TRUE AND status = 1", nativeQuery=true)
    List <Articulo> getInsumos();
    
    @Override
	@Query(value = "SELECT * FROM articulo WHERE status = 1", nativeQuery = true)
	public Page<Articulo> findAll(Pageable page);
}
