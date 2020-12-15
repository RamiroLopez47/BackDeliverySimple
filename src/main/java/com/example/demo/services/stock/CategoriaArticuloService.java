package com.example.demo.services.stock;

import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.demo.entities.stock.CategoriaArticulo;
import com.example.demo.repositories.stock.CategoriaArticuloRepository;

@Service
public class CategoriaArticuloService extends BaseService<CategoriaArticulo, CategoriaArticuloRepository> {

    @Override
    public CategoriaArticulo update(long id, CategoriaArticulo categoriaArticulo) throws Exception {
        try {
            Optional<CategoriaArticulo> entityOptional =this.repository.findById(id);
            categoriaArticulo.setId(entityOptional.get().getId());
            categoriaArticulo = this.repository.save(categoriaArticulo);

            return categoriaArticulo;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }
}
