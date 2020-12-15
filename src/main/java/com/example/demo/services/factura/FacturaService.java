package com.example.demo.services.factura;

import com.example.demo.entities.factura.Factura;
import com.example.demo.repositories.factura.FacturaRepository;
import com.example.demo.services.BaseService;

import org.springframework.stereotype.Service;

@Service
public class FacturaService extends BaseService<Factura, FacturaRepository> {

}