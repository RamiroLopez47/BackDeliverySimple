package com.example.demo.entities.formaPago;

import com.example.demo.entities.BaseEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "TARJETA")
public class Tarjeta extends FormaPago{

    
    private Long numeroDeTarjeta;
    private Long numeroDocumento;
    private String tipoDeTarjeta;
    private int pin;
    private int cvv;
  private int cantidadCuotas;

    public Tarjeta() {
    }
    

    public Long getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(Long numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getTipoDeTarjeta() {
        return tipoDeTarjeta;
    }

    public void setTipoDeTarjeta(String tipoDeTarjeta) {
        this.tipoDeTarjeta = tipoDeTarjeta;
    }

 
    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

   


    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    
}