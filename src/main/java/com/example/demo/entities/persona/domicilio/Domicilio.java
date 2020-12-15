package com.example.demo.entities.persona.domicilio;

import com.example.demo.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Domicilio  extends BaseEntity {

	@Column(nullable = true)
    private String barrio;	
	
	@Column(nullable = true)
    private String calle;	

	@Column(nullable = true)
    private Integer numero;

	@Column(nullable = true)
    private Character manzana;
   
	@Column(nullable = true)
    private Integer piso;
    
	@Column(nullable = true)
    private String puerta;

    @OneToOne
    private Localidad localidad;

    public Domicilio() {
    	super();
    }

	public Domicilio(String barrio, String calle, Integer numero, Character manzana, Integer piso, String puerta,
			Localidad localidad) {
		super();
		this.barrio = barrio;
		this.calle = calle;
		this.numero = numero;
		this.manzana = manzana;
		this.piso = piso;
		this.puerta = puerta;
		this.localidad = localidad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Character getManzana() {
		return manzana;
	}

	public void setManzana(Character manzana) {
		this.manzana = manzana;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

    
}
