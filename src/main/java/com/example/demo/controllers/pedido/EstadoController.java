package com.example.demo.controllers.pedido;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.pedido.Estado;
import com.example.demo.services.pedido.EstadoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/estado")
public class EstadoController extends BaseController<Estado, EstadoService> {
}
