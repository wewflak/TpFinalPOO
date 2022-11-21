package ar.edu.unju.escmi.poo.dao;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;

public interface IClienteDao {

	public void agregarCliente(Cliente client) throws Exception;
	public Cliente buscarCliente(Long doc);
	public Cliente agregarUsuarioACliente(Cliente client, Usuario user) throws Exception;
    public List<Cliente> obtenerClientes();
    public Cliente buscarClientePorUsuario(String email);
    public Optional<Cliente> comprobarExistenciaDNI(Long doc);
}
