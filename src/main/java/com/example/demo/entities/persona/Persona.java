package com.example.demo.entities.persona;

import javax.persistence.*;

import com.example.demo.entities.BaseEntity;

@MappedSuperclass
public class Persona extends BaseEntity {

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private String email;

	@Column
	private long telefono;

	public Persona(String nombre, String apellido, String email, long telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Persona() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono
				+ "]";
	}

}
