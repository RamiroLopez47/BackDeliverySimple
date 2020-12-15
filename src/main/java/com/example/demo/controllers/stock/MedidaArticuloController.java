package com.example.demo.controllers.stock;

import com.example.demo.controllers.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.stock.MedidaArticulo;

import com.example.demo.services.stock.MedidaArticuloService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/medidaArticulo")
public class MedidaArticuloController extends BaseController<MedidaArticulo, MedidaArticuloService> {

}
