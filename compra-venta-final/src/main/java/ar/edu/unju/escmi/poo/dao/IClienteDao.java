package ar.edu.unju.escmi.poo.dao;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;

public interface IClienteDao {

	public void agregarCliente(Cliente client, Usuario user, Rol role);
	public Cliente buscarCliente(Long doc);
    public List<Cliente> obtenerClientes();
}
