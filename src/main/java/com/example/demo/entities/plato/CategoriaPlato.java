//Paquetes:
package com.example.demo.entities.plato;

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
@Table(name = "categoriaplato")

public class CategoriaPlato extends BaseEntity {

	// Atributos:
	@Column
	private String denominacion;
	@Column
	private String descripcion;

	// Relaciones:

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "categoriaPlato_categoriaPlato")
	private List<CategoriaPlato> categoriaPlato = new ArrayList<CategoriaPlato>();

	// Constructor por defecto:
	public CategoriaPlato() {
	}

	// Constructor Sobrecargado:
	public CategoriaPlato(String denominacion, String descripcion

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


	// Setters:
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	// Metodos:

	public void agregarCategoriaPlato(CategoriaPlato categoriaPlato) {
		this.categoriaPlato.add(categoriaPlato);
	}

	public void removerCategoriaPlato(CategoriaPlato categoriaPlato) {
		this.categoriaPlato.add(categoriaPlato);
	}

	public List<CategoriaPlato> getCategoriaPlato() {
		return categoriaPlato;
	}

	public void setCategoriaPlato(List<CategoriaPlato> categoriaPlato) {
		this.categoriaPlato = categoriaPlato;
	}

	

}
