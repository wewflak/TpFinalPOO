package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IRolDao;

public class RolDaoIMP implements IRolDao {
	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();
	@Override
	public void agregarRol(Rol role) {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(role);
			manager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.toString()+" "+ e.getMessage() + " " + e.getCause());
		}
	}

	@Override
	public Rol buscarRol(int Id) {
		// TODO Auto-generated method stub
		return manager.find(Rol.class, Id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> mostrarRoles() {
		// TODO Auto-generated method stub
		//List<Cliente> clientes = (List<Cliente>) manager.createQuery("SELECT c FROM Cliente c").getResultList();
//		return clientes;
		List<Rol> roles = (List<Rol>) manager.createQuery("SELECT r FROM Rol r").getResultList();
		
		return  roles;
	}

}
