package com.example.demo.entities.persona.domicilio;

import com.example.demo.entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Localidad extends BaseEntity {

    private String denominacion;

    @OneToOne(fetch = FetchType.EAGER)
    private Departamento departamento;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
