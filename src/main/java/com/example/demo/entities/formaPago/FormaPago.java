package com.example.demo.entities.formaPago;

import java.util.Date;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.factura.Factura;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FormaPago extends BaseEntity {
private double cantidadPagado;

public double getCantidadPagado() {
    return cantidadPagado;
}

public void setCantidadPagado(double cantidadPagado) {
    this.cantidadPagado = cantidadPagado;
}

}