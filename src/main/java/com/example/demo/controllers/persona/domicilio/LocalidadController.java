package com.example.demo.controllers.persona.domicilio;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.domicilio.Localidad;
import com.example.demo.services.persona.domicilio.LocalidadService;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/localidad")
public class LocalidadController extends BaseController<Localidad, LocalidadService> {
	
	@Autowired
	private LocalidadService localidadSevice;
	
	@GetMapping("/by")
	@Transactional
	public ResponseEntity<?> getSelect(@RequestParam(value = "departamentoId") long departamentoId, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value =  "size", defaultValue = "10") int size) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(this.localidadSevice.findByDepartamento(departamentoId, page, size));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
		}

	}
}
