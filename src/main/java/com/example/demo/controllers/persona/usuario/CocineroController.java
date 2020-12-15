package com.example.demo.controllers.persona.usuario;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Cocinero;
import com.example.demo.services.persona.usuario.CocineroService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cocinero")
public class CocineroController extends BaseController<Cocinero, CocineroService> {


    @GetMapping("/cocinerosActivos")
    public ResponseEntity<?> cocinerosActivos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.cocinerosActivos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"\"Error en buscar estado: \"" + e.getMessage() + "\"}");
        }
    }
}