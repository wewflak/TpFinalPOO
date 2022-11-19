package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.components.Usuario;

public interface IUsuarioDao {

	public Usuario buscarUsuario(String email, String password);
}
