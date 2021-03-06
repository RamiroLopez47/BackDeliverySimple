package com.example.demo.controllers.plato;

import com.example.demo.controllers.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.plato.CategoriaPlato;

import com.example.demo.services.plato.CategoriaPlatoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/categoriaPlato")
public class CategoriaPlatoController extends BaseController<CategoriaPlato, CategoriaPlatoService> {

}
