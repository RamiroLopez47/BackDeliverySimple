package com.example.demo.services.persona.domicilio;

import java.util.List;

import com.example.demo.entities.persona.domicilio.Localidad;
import com.example.demo.repositories.persona.domicilio.LocalidadRepository;
import com.example.demo.services.BaseService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService extends BaseService<Localidad, LocalidadRepository> {
    
    public List<Localidad> findByDepartamento(long departamentoId, int page, int size) throws Exception {
        try {
            Pageable pageable = PageRequest.of(page, size);
            return repository.findByDepartamento(departamentoId, pageable);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    
    
}
