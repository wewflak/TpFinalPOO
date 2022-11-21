package ar.edu.unju.escmi.poo.dao;

import java.util.Optional;

import ar.edu.unju.escmi.poo.components.Usuario;

public interface IUsuarioDao {
	public void agregarUsuario(Usuario user) throws Exception;
	public Usuario buscarUsuario(String email, String password);
	public Optional<Usuario> comprobarExistenciaEmail(String email);
	public Optional<Usuario> comprobarExistenciaContrasena(String password);
	
}
