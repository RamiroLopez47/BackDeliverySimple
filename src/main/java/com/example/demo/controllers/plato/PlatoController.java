package com.example.demo.controllers.plato;

import java.util.Date;

import javax.transaction.Transactional;

import com.example.demo.controllers.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.plato.Plato;

import com.example.demo.services.plato.PlatoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/plato")
public class PlatoController extends BaseController<Plato, PlatoService> {
	@Autowired
	private PlatoService platoService;

	@GetMapping("/byCategoria")
	@Transactional
	public ResponseEntity<?> getSelect(@RequestParam(value = "categoria") String categoria, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value =  "size", defaultValue = "10") int size) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(platoService.findByCategoria(categoria, page, size));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
		}

	}
	@GetMapping("/topPlatos")
	public ResponseEntity topPlatos(@RequestParam(value = "")String fechaInicio, @RequestParam(value = "") String fechaFin) throws Exception{
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.topPlatos(fechaInicio,fechaFin));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}	
		
	}
	@GetMapping("/entre/cantidad")	
	public ResponseEntity findBetweenDates(@RequestParam(value = "") String fechaInicio,@RequestParam(value = "") String fechaFin) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findBetweenDatesCount(fechaInicio,  fechaFin));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
	}
}
