package com.example.demo.controllers.persona.usuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Rol;
import com.example.demo.services.persona.usuario.RolService;

@RestController
@RequestMapping(path = "api/v1/rol")
public class RolController extends BaseController<Rol, RolService> {

}
