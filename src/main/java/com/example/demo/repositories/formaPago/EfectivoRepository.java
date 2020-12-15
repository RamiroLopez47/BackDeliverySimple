package com.example.demo.repositories.formaPago;

import com.example.demo.entities.formaPago.Efectivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfectivoRepository extends JpaRepository<Efectivo,Long>{
    
}