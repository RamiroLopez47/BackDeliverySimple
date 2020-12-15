package com.example.demo.controllers.stock;

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

import com.example.demo.entities.stock.Articulo;

import com.example.demo.services.stock.ArticuloService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/articulo")
public class ArticuloController extends BaseController<Articulo, ArticuloService> {
	@Autowired
	private ArticuloService articuloService;

	@GetMapping("/byCategoria")
	@Transactional
	public ResponseEntity<?> getSelect(@RequestParam(value = "categoria") String categoria) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(articuloService.findByCategoria(categoria));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
		}
	
	}
	
	@GetMapping("/stockBajo")
	public ResponseEntity stockBajo() throws Exception {		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.stockBajo());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}		
	}
	
	@GetMapping("/reventa")
	public ResponseEntity getProductoReventa() throws Exception {		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getProductoReventa());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}		
	}
	
	@GetMapping("/insumos")
	public ResponseEntity getInsumos() throws Exception {		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getInsumos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}		
	}
	
}
