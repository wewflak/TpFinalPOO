package ar.edu.unju.escmi.poo.components;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import jakarta.persistence.InheritanceType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
@Table(name="Clientes")
@Entity
public class Cliente  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer idCliente;
	private String nombre;
	private String apellido;
	@Column(unique=true, nullable=false)
	private Long dni;
	private LocalDate fechaDeN;
	@OneToOne(fetch =FetchType.LAZY)
	private Usuario usuario;
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeN() {
		return fechaDeN;
	}
	public void setFechaDeN(LocalDate fechaDeN) {
		this.fechaDeN = fechaDeN;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cliente(String nombre, String apellido, Long dni, LocalDate fechaDeN, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeN = fechaDeN;
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Cliente y Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaDeN=" + fechaDeN
				+ ", email=" + usuario.getEmail() + ", contrasena= " + usuario.getContrasena() +", rol" + usuario.getRol().getDescripcion()+"]";
	}
	
	
}
