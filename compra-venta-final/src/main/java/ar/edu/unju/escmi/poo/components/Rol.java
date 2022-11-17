package ar.edu.unju.escmi.poo.components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	private String descripcion;
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Rol(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
}
