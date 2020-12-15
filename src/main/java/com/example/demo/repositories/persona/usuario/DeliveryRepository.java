package com.example.demo.repositories.persona.usuario;

import com.example.demo.entities.persona.usuario.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
