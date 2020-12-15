package com.example.demo.controllers.persona.domicilio;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.domicilio.Departamento;
import com.example.demo.services.persona.domicilio.DepartamentoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/departamento")
public class DepartamentoController extends BaseController<Departamento, DepartamentoService> {
}
