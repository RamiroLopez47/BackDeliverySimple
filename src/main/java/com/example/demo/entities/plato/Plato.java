//Paquetes:
package com.example.demo.entities.plato;

import com.example.demo.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "plato")

public class Plato extends BaseEntity {

	// Atributos:
	@Column
	private String denominacion;
	@Column
	private int tiempoPreparacion;
	@Column
	private String imagen;
	@Column
	private float precioVenta;
	@Lob
	@Column
	private String receta;

	// Relaciones:

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "plato_categoriaPlato")
	private CategoriaPlato categoriaPlato;
	// Composición, me lo indica el cascade ALL
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "detallePlato_plato")
	private List<DetallePlato> detallePlato = new ArrayList<DetallePlato>();

	// Constructor por defecto:
	public Plato() {
	}

	// Constructor Sobrecargado:
	public Plato(String denominacion, int tiempoPreparacion, String imagen, float precioVenta
			, ArrayList<DetallePlato> detallePlato, String receta) {
		this.denominacion = denominacion;
		this.tiempoPreparacion = tiempoPreparacion;
		this.imagen = imagen;
		this.precioVenta = precioVenta;
		this.receta = receta;
		this.detallePlato = detallePlato;
	}

	// Getters:
	public String getDenominacion() {
		return this.denominacion;
	}

	public int getTiempoPreparacion() {
		return this.tiempoPreparacion;
	}

	public String getImagen() {
		return this.imagen;
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}
	
	public String getReceta() {
		return this.receta;
	}

	// Setters:
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setCategoriaPlato(CategoriaPlato categoriaPlato) {
		this.categoriaPlato = categoriaPlato;
	}
	
	public void setReceta(String receta) {
		this.receta = receta;
	}

	// Metodos:

	public void agregarDetallePlato(DetallePlato detallePlato) {
		this.detallePlato.add(detallePlato);
	}

	public void removerDetallePlato(DetallePlato detallePlato) {
		this.detallePlato.add(detallePlato);
	}

	public CategoriaPlato getCategoriaPlato() {
		return categoriaPlato;
	}

	public List<DetallePlato> getDetallePlato() {
		return detallePlato;
	}

	public void setDetallePlato(List<DetallePlato> detallePlato) {
		this.detallePlato = detallePlato;
	}

}
