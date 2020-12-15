package com.example.demo.entities.factura;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.formaPago.FormaPago;
import com.example.demo.entities.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Factura extends BaseEntity {

    private double total;
    private Date fecha;

    private int numero;

    private double descuento;


    // Agregación, no hay cascade ALL
    // Con FetchType.EAGER en agregación no compila,da un error

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "factura"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "factura")
	private Pedido pedido;


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

 



}