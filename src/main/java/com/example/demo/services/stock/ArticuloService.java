package com.example.demo.services.stock;

import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.stock.Articulo;
import com.example.demo.repositories.stock.ArticuloRepository;

@Service
public class ArticuloService extends BaseService<Articulo, ArticuloRepository> {

    // Para no incluir en el cuerpo del postman el id cuando hago el put. Evitando
    // que se cree otro objeto
    @Override
    public Articulo update(long id, Articulo articulo) throws Exception {
        try {
            Optional<Articulo> entityOptional = this.repository.findById(id);
            articulo.setId(entityOptional.get().getId());
            articulo = this.repository.save(articulo);

            return articulo;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }

    public List<Articulo> findByCategoria(String categoria) {
        return this.repository.findByCategoria(categoria);
    }
    
    public List <Articulo> stockBajo() throws Exception {		
		try {
			return this.repository.stockBajo();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    public List <Articulo> getProductoReventa() throws Exception {		
		try {
			return this.repository.getProductoReventa();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    public List <Articulo> getInsumos() throws Exception {		
		try {
			return this.repository.getInsumos();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
