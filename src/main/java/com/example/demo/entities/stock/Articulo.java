//Paquetes:
package com.example.demo.entities.stock;

import com.example.demo.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulo")

public class Articulo extends BaseEntity {

	// Atributos:
	@Column
	private String denominacion;

	@Column
	private String descripcion;
	@Column
	
	private Float stockMin;
	@Column
	private Float stockMax;
	@Column
	private Float stockActual;
	@Column
	private boolean esInsumo;
	@Column
	private String imagen;
	@Column
	private float precioCompra;
	@Column
	private float precioVenta;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articulo_categoriaArticulo")
	private CategoriaArticulo categoriaArticulo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "articulo_medidaArticulo")
	private MedidaArticulo medidaArticulo;

	// Relaciones:

/*
	@OneToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "articulo_categoriaArticulo")
	private CategoriaArticulo categoriaArticulo;
	

	//Con esas cascadas puedo crear la medida y editarlo por ejemplo, pero 
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "articulo_medidaArticulo")
	private MedidaArticulo medidaArticulo;
*/
	// Constructor por defecto:
	public Articulo() {
	}
	


	// Constructor Sobrecargado:

	// Getters:
	public String getDenominacion() {
		return this.denominacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Float getStockMin() {
		return this.stockMin;
	}

	public Float getStockMax() {
		return this.stockMax;
	}

	public Float getStockActual() {
		return this.stockActual;
	}

	public boolean getEsInsumo() {
		return this.esInsumo;
	}

	public String getImagen() {
		return this.imagen;
	}

	public float getPrecioCompra() {
		return this.precioCompra;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	

	// Setters:
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setStockMin(Float stockMin) {
		this.stockMin = stockMin;
	}

	public void setStockMax(Float stockMax) {
		this.stockMax = stockMax;
	}

	public void setStockActual(Float stockActual) {
		this.stockActual = stockActual;
	}

	public void setEsInsumo(boolean esInsumo) {
		this.esInsumo = esInsumo;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
		this.categoriaArticulo = categoriaArticulo;
	}

	public void setMedidaArticulo(MedidaArticulo medidaArticulo) {
		this.medidaArticulo = medidaArticulo;
	}

	public MedidaArticulo getMedidaArticulo() {
		return medidaArticulo;
	}

	public CategoriaArticulo getCategoriaArticulo() {
		return categoriaArticulo;
	}


	// Metodos:

}
