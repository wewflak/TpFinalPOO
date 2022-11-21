package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Usuario;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IUsuarioDao;

public class UsuarioDaoIMP implements IUsuarioDao {

	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public Usuario buscarUsuario(String email, String password) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT u FROM Usuario u " + " WHERE u.email = :email AND u.contrasena = :password ");
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (Usuario) query.getSingleResult();
		//return manager.find(Usuario.class, email);
	}

	@Override
	public void agregarUsuario(Usuario user) throws Exception {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			
		}catch(Exception ime) {
			if(ime instanceof PersistenceException) {
				throw new Exception("Ya existe un usuario con ese email");
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Usuario> comprobarExistenciaEmail(String email) {
		// TODO Auto-generated method stub
		Optional<Usuario> encontrado = Optional.empty();
		Query query = manager.createQuery("SELECT u FROM Usuario u " + " WHERE u.email = :email ");
        query.setParameter("email", email);
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        encontrado = usuarios.stream().filter(u-> u.getEmail().equals(email)).findFirst();
		return encontrado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Usuario> comprobarExistenciaContrasena(String password) {
		// TODO Auto-generated method stub
		Optional<Usuario> encontrado = Optional.empty();
		Query query = manager.createQuery("SELECT u FROM Usuario u " + " WHERE u.contrasena = :password ");
        query.setParameter("password", password);
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        encontrado = usuarios.stream().filter(u-> u.getContrasena().equals(password)).findFirst();
        
		return encontrado;
	}

	@Override
	public Usuario buscarUsuarioDni(Long doc) {
		// TODO Auto-generated method stub
		try {
			Query query = manager.createQuery("SELECT u FROM Usuario u " + " WHERE u.dni = :dni");
			query.setParameter("dni", doc);
			return (Usuario) query.getSingleResult();
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("ERROR*******************************");
			if(e instanceof NullPointerException) {
				System.out.println("El dni no fue registrado anteriormente");
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Usuario> comprobarExistenciaDNI(Long doc) {
		// TODO Auto-generated method stub
		Optional<Usuario> encontrado = Optional.empty();
		Query query = manager.createQuery("SELECT u FROM Usuario u " + " WHERE u.dni = :dni");
		query.setParameter("dni", doc);
		List<Usuario> clientes = (List<Usuario>) query.getResultList();
		encontrado = clientes.stream().filter(c-> c.getDni().equals(doc)).findFirst();
		return encontrado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = (List<Usuario>) manager.createQuery("SELECT u FROM Usuario u").getResultList();
		return usuarios;
	}

}
