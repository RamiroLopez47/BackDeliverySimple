package com.example.demo.controllers.persona.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Cajero;
import com.example.demo.services.persona.usuario.CajeroService;

@RestController
@RequestMapping(path = "api/v1/cajero")
public class CajeroController extends BaseController<Cajero, CajeroService> {
    @Autowired
    private CajeroService cajeroServicio;

    @GetMapping("/byEmail")
    @Transactional
    public ResponseEntity<?> getSelect(@RequestParam(value = "email") String email) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(cajeroServicio.findByEmail(email));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }
}
