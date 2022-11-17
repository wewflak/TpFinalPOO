package ar.edu.unju.escmi.poo.components;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Usuario {
	@Id
	private String email;
	private String contrasena;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rol_id")
	private Rol rol;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario(String email, String contrasena, Rol rol) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
}
