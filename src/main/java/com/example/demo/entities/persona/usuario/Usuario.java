package com.example.demo.entities.persona.usuario;

import com.example.demo.entities.persona.Persona;
import com.example.demo.entities.persona.domicilio.Domicilio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // Si no se coloca JOINED es
// single por defecto y se creara un campo de
// // Dtype para las que heredan de esta, pero debe ser una entidad
// tambien
@DiscriminatorColumn(name="tipo")
public class Usuario extends Persona {

	@Column(nullable = true)
	private String password;

	@JoinColumn(name = "domicilio_usuario")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Domicilio> domicilios = new ArrayList();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_rol")
	private Rol rol;


	public Usuario(String nombre, String apellido, String email, long telefono, String password, List<Domicilio> domicilios, Rol rol) {
		super(nombre, apellido, email, telefono);
		this.password = password;
		this.domicilios = domicilios;
		this.rol = rol;
	}

	public Usuario() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [password=" + password + ", rol=" + rol + "]";
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

}
