package com.example.demo.services.pedido;

import com.example.demo.entities.pedido.Estado;
import com.example.demo.repositories.pedido.EstadoRepository;
import com.example.demo.services.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends BaseService<Estado, EstadoRepository> {

	public Estado getByDenominacion(String denominacion) throws Exception{
		try {
			return this.repository.findByDenominacion(denominacion);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
