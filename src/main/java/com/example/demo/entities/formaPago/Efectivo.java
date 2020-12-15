package com.example.demo.entities.formaPago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "CONTADO")
public class Efectivo extends FormaPago {

 

    
}