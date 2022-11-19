package ar.edu.unju.escmi.poo.dao.imp;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IDetalleDao;

public class DetalleDaoIMP implements IDetalleDao{
	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();


	@Override
	public void crearDetalle(Detalle detail) {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(detail);
			manager.getTransaction().commit();
		}catch(Exception ime) {
			System.out.println(ime);
		}
	}

	@Override
	public Double calcularImporte(Detalle detail) {
		// TODO Auto-generated method stub
//		detail.setImporteDetalle(null);
//		manager.refresh(detail);
		return null;
	}

	@Override
	public Detalle buscarDetalle(int id) {
		// TODO Auto-generated method stub
		return manager.find(Detalle.class, id);
	}

}
