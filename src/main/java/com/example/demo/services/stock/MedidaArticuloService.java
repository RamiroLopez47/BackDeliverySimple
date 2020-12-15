package com.example.demo.services.stock;

import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.example.demo.entities.stock.MedidaArticulo;
import com.example.demo.repositories.stock.MedidaArticuloRepository;

@Service
public class MedidaArticuloService extends BaseService<MedidaArticulo, MedidaArticuloRepository> {

    @Override
    public MedidaArticulo update(long id, MedidaArticulo medidaArticulo) throws Exception {
        try {
            Optional<MedidaArticulo> entityOptional =this.repository.findById(id);
            medidaArticulo.setId(entityOptional.get().getId());
            medidaArticulo = this.repository.save(medidaArticulo);

            return medidaArticulo;

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }

    }
}
