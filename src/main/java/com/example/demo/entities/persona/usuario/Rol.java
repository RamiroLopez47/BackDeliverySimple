package com.example.demo.entities.persona.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.entities.BaseEntity;

@Entity
public class Rol extends BaseEntity {

	

	private String denominacion;

	public Rol() {
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	@Override
	public String toString() {
		return "Rol [denominacion=" + denominacion + "]";
	}

}
