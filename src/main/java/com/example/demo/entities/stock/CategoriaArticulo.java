//Paquetes:
package com.example.demo.entities.stock;

import com.example.demo.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoriaarticulo")

public class CategoriaArticulo extends BaseEntity {

	// Atributos:
	@Column
	private String denominacion;
	@Column
	private String descripcion;

	// Relaciones:

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "categoriaArticulo_categoriaArticulo")
	private List<CategoriaArticulo> categoriaArticulo = new ArrayList<CategoriaArticulo>();

	// Constructor por defecto:
	public CategoriaArticulo(

	) {
	}

	// Constructor Sobrecargado:
	public CategoriaArticulo(String denominacion, String descripcion

	) {

		this.denominacion = denominacion;
		this.descripcion = descripcion;

	}

	// Getters:
	public String getDenominacion() {
		return this.denominacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public List<CategoriaArticulo> getCategoriaArticulo() {
		return this.categoriaArticulo;
	}

	// Setters:
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Metodos:

	public void agregarCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
		this.categoriaArticulo.add(categoriaArticulo);
	}

	public void removerCategoriaArticulo(CategoriaArticulo categoriaArticulo) {
		this.categoriaArticulo.add(categoriaArticulo);
	}

	public void setCategoriaArticulo(List<CategoriaArticulo> categoriaArticulo) {
		this.categoriaArticulo = categoriaArticulo;
	}

}
