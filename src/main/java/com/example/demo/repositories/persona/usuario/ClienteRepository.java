package com.example.demo.repositories.persona.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.persona.usuario.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);
}
