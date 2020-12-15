package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.persona.domicilio.Domicilio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Empleado extends Usuario {

	@Column(nullable = true)
	private Integer dni;

	@Column(nullable = true)
	private Date fechaIngresoEmpleado;

	@Column(nullable = true)
	private Boolean estaActivo;

	public Empleado() {
	}

	public Empleado(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol, Integer dni, Date fechaIngresoEmpleado, Boolean estaActivo) {
		super(nombre, apellido, email, telefono, password, domicilios, rol);
		this.dni = dni;
		this.fechaIngresoEmpleado = fechaIngresoEmpleado;
		this.estaActivo = estaActivo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean isEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public Date getFechaIngresoEmpleado() {
		return fechaIngresoEmpleado;
	}

	public void setFechaIngresoEmpleado(Date fechaIngresoEmpleado) {
		this.fechaIngresoEmpleado = fechaIngresoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", estaActivo=" + estaActivo + ", fechaIngresoEmpleado=" + fechaIngresoEmpleado
				+ "]";
	}

}
