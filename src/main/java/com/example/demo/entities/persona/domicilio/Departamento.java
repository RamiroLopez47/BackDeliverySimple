package com.example.demo.entities.persona.domicilio;

import javax.persistence.Entity;

import com.example.demo.entities.BaseEntity;

@Entity
public class Departamento extends BaseEntity {
    private String denominacion;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

}