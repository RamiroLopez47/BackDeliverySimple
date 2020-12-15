package com.example.demo.controllers.persona.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.transaction.Transactional;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Usuario;
import com.example.demo.services.persona.usuario.UsuarioService;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioService> {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/byEmail")
    @Transactional
    public ResponseEntity<?> getSelect(@RequestParam(value = "email") String email) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByEmail(email));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }
    
    @GetMapping("/clientesPeriodo")
	public ResponseEntity clientesPeriodo(@RequestParam(value = "")String fechaInicio, @RequestParam(value = "") String fechaFin) throws Exception{
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.clientesPeriodo(fechaInicio, fechaFin));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
		}
		}
}