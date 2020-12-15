package com.example.demo.repositories.formaPago;

import com.example.demo.entities.formaPago.Tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
    
}