package com.example.demo.controllers.persona.usuario;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Gerente;
import com.example.demo.services.persona.usuario.GerenteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/gerente")
public class GerenteController extends BaseController<Gerente, GerenteService> {
}
