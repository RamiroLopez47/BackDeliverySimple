package com.example.demo.services.plato;

import com.example.demo.services.BaseService;
import com.example.demo.services.pedido.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.example.demo.dtos.PlatoDTO;
import com.example.demo.entities.pedido.DetallePedido;
import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.plato.Plato;
import com.example.demo.repositories.plato.PlatoRepository;

@Service
public class PlatoService extends BaseService<Plato, PlatoRepository> {

    @Autowired
    private PedidoService pedidoService;
    public List<Plato> findByCategoria(String categoria, int page, int size) throws Exception {
        try {
            Pageable pageable = PageRequest.of(page, size);
            return repository.findByCategoria(categoria, pageable);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    public List <Plato> topPlatos(String fechaInicio, String fechaFin) throws Exception{
		try {
			return this.repository.topPlatos(fechaInicio, fechaFin);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	public List<PlatoDTO> findBetweenDatesCount(String fecha1,String fecha2){
		List<Pedido> pedidos = pedidoService.findBetweenDates(fecha1, fecha2);
		return calcularCantidadPlatos(pedidos);
	
	}

public  List<PlatoDTO> calcularCantidadPlatos(List<Pedido> pedidos) {
		List<PlatoDTO> platosDTOList = new ArrayList<>();
		HashMap<String, Integer> platosMap = new HashMap<String, Integer>();
		int total = 0;
		String denominacion = "";
		for (Pedido pedido : pedidos) {

			for (DetallePedido detalle : pedido.getDetallesPedido()) {
				denominacion = detalle.getPlato().getDenominacion();
				

				if (platosMap.containsKey(denominacion)) {
					total = platosMap.get(denominacion) + detalle.getCantidad();
					platosMap.put(denominacion, total);
				} else {
					platosMap.put(denominacion, detalle.getCantidad());
				}

			}
        }
        platosMap.forEach((k,v) -> platosDTOList.add(new PlatoDTO(k,v)));
		return platosDTOList;
	}

}
