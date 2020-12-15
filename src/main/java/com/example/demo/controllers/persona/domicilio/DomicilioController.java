package com.example.demo.controllers.persona.domicilio;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.domicilio.Domicilio;
import com.example.demo.services.persona.domicilio.DomicilioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/domicilio")
public class DomicilioController  extends BaseController<Domicilio, DomicilioService> {
}
