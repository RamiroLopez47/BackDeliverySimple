package com.example.demo.services.persona.usuario;

import java.util.List;

import com.example.demo.entities.persona.usuario.Cocinero;
import com.example.demo.repositories.persona.usuario.CocineroRepository;
import com.example.demo.services.BaseService;

import org.springframework.stereotype.Service;

@Service
public class CocineroService extends BaseService<Cocinero, CocineroRepository> {
    public Cocinero findByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    public List<Cocinero> cocinerosActivos() throws Exception{
        try {
            return this.repository.cocinerosActivos();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}