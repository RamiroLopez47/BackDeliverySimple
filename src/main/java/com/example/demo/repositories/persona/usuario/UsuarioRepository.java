package com.example.demo.repositories.persona.usuario;

import com.example.demo.entities.persona.usuario.Usuario;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    
    @Query(value = "SELECT * FROM usuario WHERE id IN (SELECT cliente_id FROM pedido WHERE fecha BETWEEN ?1 AND ?2)", nativeQuery = true)
	List<Usuario> clientesPeriodo(String fechaInicio, String fechaFin);
}
