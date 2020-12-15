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
import com.example.demo.entities.persona.usuario.Cliente;
import com.example.demo.services.persona.usuario.ClienteService;

@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController extends BaseController<Cliente, ClienteService> {
    @Autowired
    private ClienteService clienteServicio;

    @GetMapping("/byEmail")
    @Transactional
    public ResponseEntity<?> getSelect(@RequestParam(value = "email") String email) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.findByEmail(email));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }

    @GetMapping("/platos/cliente-unico")
    @Transactional
    public ResponseEntity<?> getCantidadPlatosBetweenDates(@RequestParam(value = "") String fechaInicio,@RequestParam(value = "") String fechaFin,@RequestParam(value = "") String email) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.getCantidadPlatos(fechaInicio,fechaFin,email));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }

    @GetMapping("/platos/lista-clientes")
    @Transactional
    public ResponseEntity<?> getCantidadPlatosBetweenDatesOfClientes(@RequestParam(value = "") String fechaInicio,@RequestParam(value = "") String fechaFin) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.getCantidadPlatosOfClientes(fechaInicio,fechaFin));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }
    @GetMapping("/pedidos")
    @Transactional
    public ResponseEntity<?> getCantidadPedidosAgrupados(@RequestParam(value = "") String fechaInicio,@RequestParam(value = "") String fechaFin) {

        try {

            return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.getCantidadPedidosAgrupados(fechaInicio,fechaFin));

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"The consultation was unsuccessful\": \"" + e.getMessage() + "\"}");
        }

    }
}
