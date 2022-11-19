package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

}
