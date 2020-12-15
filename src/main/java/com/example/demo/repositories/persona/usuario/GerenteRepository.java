package com.example.demo.repositories.persona.usuario;

import com.example.demo.entities.persona.usuario.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente,Long> {
}
