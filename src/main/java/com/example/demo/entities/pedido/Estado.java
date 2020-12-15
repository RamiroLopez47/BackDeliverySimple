package com.example.demo.entities.pedido;

import com.example.demo.entities.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Estado extends BaseEntity {

    private String denominacion;

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estado other = (Estado) obj;
        if (denominacion == null) {
            if (other.denominacion != null)
                return false;
        } else if (!denominacion.equals(other.denominacion))
            return false;
        return true;
    }

    
}
