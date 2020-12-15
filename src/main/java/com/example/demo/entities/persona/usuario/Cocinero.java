package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="COCINERO")
public class Cocinero extends Empleado {

	@Column(nullable = true)
    private String cargo;

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "cocinero"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cocinero")
    private List<Pedido> pedidos = new ArrayList();

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}