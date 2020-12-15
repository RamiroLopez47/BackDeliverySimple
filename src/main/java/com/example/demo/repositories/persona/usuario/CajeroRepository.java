package com.example.demo.repositories.persona.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.persona.usuario.Cajero;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Long> {
    Cajero findByEmail(String email);
}
