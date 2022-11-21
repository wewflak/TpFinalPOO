package ar.edu.unju.escmi.poo.dao;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Usuario;

public interface IUsuarioDao {
	public void agregarUsuario(Usuario user) throws Exception;
	public Usuario buscarUsuarioDni(Long doc);
	public Usuario buscarUsuario(String email, String password);
	public List<Usuario> obtenerUsuarios();
    public Optional<Usuario> comprobarExistenciaDNI(Long doc);
	public Optional<Usuario> comprobarExistenciaEmail(String email);
	public Optional<Usuario> comprobarExistenciaContrasena(String password);
	
}
