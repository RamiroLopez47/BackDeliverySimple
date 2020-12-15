package com.example.demo.controllers.persona.usuario;

import com.example.demo.controllers.BaseController;
import com.example.demo.entities.persona.usuario.Delivery;
import com.example.demo.services.persona.usuario.DeliveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/delivery")
public class DeliveryController extends BaseController<Delivery, DeliveryService> {
}
