package com.example.demo.entities.persona.usuario;




import com.example.demo.entities.persona.domicilio.Domicilio;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "CAJERO")
public class Cajero extends Empleado {

	public Cajero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cajero(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol, Integer dni, Date fechaIngresoEmpleado, Boolean estaActivo) {
		super(nombre, apellido, email, telefono, password, domicilios, rol, dni, fechaIngresoEmpleado, estaActivo);
	}

}
