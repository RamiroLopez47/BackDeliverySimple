//Paquetes:
package com.example.demo.entities.plato;

import com.example.demo.entities.BaseEntity;
import com.example.demo.entities.stock.Articulo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name = "detalleplato")

public class DetallePlato extends BaseEntity {

	// Atributos:
	@Column
	private Float cantidad;

	// Relaciones:

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "detallePlato_articulo")
	private Articulo articulo;

//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "detallePlato_medidaPlato")
//	private MedidaPlato medidaPlato;

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "detallePlato_articulo") private Articulo articulo;
	 * 
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "detallePlato_medidaPlato") private MedidaPlato
	 * medidaPlato;
	 */
	// Constructor por defecto:
	public DetallePlato() {
	}

	// Constructor Sobrecargado:
	public DetallePlato(Float cantidad

	) {

		this.cantidad = cantidad;

	}

	// Getters:
	public Float getCantidad() {
		return this.cantidad;
	}

	// Setters:
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

//	public void setMedidaPlato(MedidaPlato medidaPlato) {
//		this.medidaPlato = medidaPlato;
//	}

	public Articulo getArticulo() {
		return articulo;
	}

//	public MedidaPlato getMedidaPlato() {
//		return medidaPlato;
//	}

	// Metodos:

}
