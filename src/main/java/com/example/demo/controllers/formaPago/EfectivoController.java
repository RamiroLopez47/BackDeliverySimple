package com.example.demo.controllers.formaPago;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.formaPago.Efectivo;
import com.example.demo.services.formaPago.EfectivoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/efectivo")
public class EfectivoController extends BaseController<Efectivo, EfectivoService> {
    
}