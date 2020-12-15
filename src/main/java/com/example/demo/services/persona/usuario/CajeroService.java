package com.example.demo.services.persona.usuario;

import org.springframework.stereotype.Service;

import com.example.demo.entities.persona.usuario.Cajero;
import com.example.demo.repositories.persona.usuario.CajeroRepository;
import com.example.demo.services.BaseService;

@Service
public class CajeroService extends BaseService<Cajero, CajeroRepository> {

    public Cajero findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

}
