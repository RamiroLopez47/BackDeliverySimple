package com.example.demo.controllers.formaPago;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.formaPago.Tarjeta;
import com.example.demo.services.formaPago.TarjetaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tarjeta")
public class TarjetaController extends BaseController<Tarjeta,TarjetaService> {
    
}