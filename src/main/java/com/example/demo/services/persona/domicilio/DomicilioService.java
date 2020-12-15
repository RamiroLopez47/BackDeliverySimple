package com.example.demo.services.persona.domicilio;

import com.example.demo.entities.persona.domicilio.Domicilio;
import com.example.demo.entities.stock.MedidaArticulo;
import com.example.demo.repositories.persona.domicilio.DomicilioRepository;
import com.example.demo.services.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;



@Service
public class DomicilioService extends BaseService<Domicilio, DomicilioRepository> {
	
}
