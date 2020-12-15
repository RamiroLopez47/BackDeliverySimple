package com.example.demo.entities.pedido;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.plato.Plato;

@Entity
public class DetallePedido extends BaseEntity {

    private double subTotal;

    private int cantidad;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "detallePedido_plato")
    private Plato plato;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

}
