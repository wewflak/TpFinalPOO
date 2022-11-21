package ar.edu.unju.escmi.poo.dao.imp;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Factura;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IClienteDao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ClienteDaoIMP implements IClienteDao {
	
	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();
	@Override
	public void agregarCliente(Cliente client) throws Exception {
		// TODO Auto-generated method stub
try {
		manager.getTransaction().begin();
		manager.persist(client);
		manager.getTransaction().commit();
}catch(Exception e) {
	System.out.println(e.toString()+" "+ e.getMessage() + " " + e.getCause());
	if(e instanceof PersistenceException) {
		throw new Exception("Ya existe un cliente con ese DNI");
	}
}
	}

	@Override
	public Cliente buscarCliente(Long doc) {
		// TODO Auto-generated method stub
		try {
			//Query query = manager.createQuery("SELECT c FROM Cliente c" + "WHERE c.dni = :doc");
			//return (Cliente) query.getSingleResult();
			Query query = manager.createQuery("SELECT c FROM Cliente c " + " WHERE c.dni = :dni");
			query.setParameter("dni", doc);
			return (Cliente) query.getSingleResult();
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("ERROR*******************************");
			if(e instanceof NullPointerException) {
				System.out.println("El dni no fue registrado anteriormente");
			}
		}
		return null;
	}
	@Override
    @SuppressWarnings("unchecked")
    public List<Cliente> obtenerClientes() {
       // try {
		List<Cliente> clientes = (List<Cliente>) manager.createQuery("SELECT c FROM Cliente c").getResultList();
		return clientes;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return null;
    }

	@Override
	public Cliente buscarClientePorUsuario(String email) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select c FROM Cliente c " + " WHERE c.usuario.email = :email");
		query.setParameter("email", email);
		return (Cliente) query.getSingleResult();
	}

	@Override
	public Cliente agregarUsuarioACliente(Cliente client, Usuario user) throws Exception {
		// TODO Auto-generated method stub
		try {
			client.setUsuario(user);
			manager.getTransaction().begin();
			manager.persist(client);
			manager.getTransaction().commit();
			
		}catch(Exception ime) {
			if(ime instanceof PersistenceException) {
				throw new Exception("Ya existe un usuario con ese email");
			}
		}
		return null;
	}

	@Override
	public Optional<Cliente> comprobarExistenciaDNI(Long doc) {
		// TODO Auto-generated method stub
		Optional<Cliente> encontrado = Optional.empty();
		Query query = manager.createQuery("SELECT c FROM Cliente c " + " WHERE c.dni = :dni");
		query.setParameter("dni", doc);
		List<Cliente> clientes = query.getResultList();
		encontrado = clientes.stream().filter(c-> c.getDni().equals(doc)).findFirst();
		return encontrado;
	}

}
