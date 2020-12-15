package com.example.demo.controllers.pedido;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.pedido.Pedido;
import com.example.demo.services.pedido.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController extends BaseController<Pedido, PedidoService> {

	@Autowired
	private PedidoService service;

	@GetMapping("/carrito")

	@Transactional
	public ResponseEntity<?> getAll(@RequestParam(value = "email") String email) {
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(service.getCarrito(email));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"Mi mensaje get todos\": \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/estado")
	public ResponseEntity<?> getPedidos(@RequestParam(value = "estado") String estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByEstado(estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}
	@GetMapping("/delivery")
	public ResponseEntity<?> getPedidosDeUnDeliveryPorEstado(@RequestParam(value = "") String email,@RequestParam(value = "") String estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByEmailOfDeliveryAndEstado(email, estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}
	@GetMapping("/cocinero")
	public ResponseEntity<?> getPedidosDeUnCocineroPorEstado(@RequestParam(value = "") String email,@RequestParam(value = "") String estado) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findPedidosByEmailOfCocineroAndEstado(email, estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}
	

	
	@GetMapping("/latest")
	public ResponseEntity<?> getLatest() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getLatestDate());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping("/columna/{columna}")	
	public ResponseEntity findByColumn(@PathVariable int columna) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByColumn(columna));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/datosCocina")
	public ResponseEntity<?> datosCocina(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.datosCocina());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}

	@GetMapping("/entre")	
	public ResponseEntity findBetweenDates(@RequestParam(value = "") String fechaInicio,@RequestParam(value = "") String fechaFin) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findBetweenDates(fechaInicio,  fechaFin));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}

	
}