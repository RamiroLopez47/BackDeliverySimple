package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.pedido.Pedido;
import com.example.demo.entities.persona.domicilio.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue(value="DELIVERY")
public class Delivery extends Empleado{

    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "delivery"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery")
    private List<Pedido> pedidos = new ArrayList();

    public Delivery() {
        super();
    }

    public Delivery(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol, Integer dni, Date fechaIngresoEmpleado, Boolean estaActivo) {
        super(nombre, apellido, email, telefono, password, domicilios, rol, dni, fechaIngresoEmpleado, estaActivo);
    }
}
