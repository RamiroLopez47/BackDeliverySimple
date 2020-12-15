package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.persona.domicilio.Domicilio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue(value="GERENTE")
public class Gerente extends Empleado{

    public Gerente() {
        super();
    }

    public Gerente(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol, Integer dni, Date fechaIngresoEmpleado, Boolean estaActivo) {
        super(nombre, apellido, email, telefono, password, domicilios, rol, dni, fechaIngresoEmpleado, estaActivo);
    }

}
