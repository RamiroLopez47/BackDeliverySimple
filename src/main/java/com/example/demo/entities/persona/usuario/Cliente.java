package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.persona.domicilio.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="CLIENTE")
public class Cliente extends Usuario {

	
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "cliente"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList();

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol) {
		super(nombre, apellido, email, telefono, password, domicilios, rol);
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [pedidos=" + pedidos + "]";
	}

	// Esta clase tiene una composicion 1 a muchos con Pedidos

}
