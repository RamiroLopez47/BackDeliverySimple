package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.pedido.Pedido;

public class ClientePedidoDTO {
    private long id;

    private String nombre;

    private String apellido;
private List<Pedido> pedidos= new ArrayList();


public ClientePedidoDTO() {
}

public ClientePedidoDTO(long id, String nombre, String apellido, List<Pedido> pedidos) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.pedidos = pedidos;
}

public ClientePedidoDTO(long id, String nombre, String apellido) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
    
