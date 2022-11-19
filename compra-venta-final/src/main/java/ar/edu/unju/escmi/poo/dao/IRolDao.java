package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.components.Rol;

public interface IRolDao {

	public void agregarRol(Rol role);
	public Rol buscarRol(int Id);
	public List<Rol> mostrarRoles();
}
