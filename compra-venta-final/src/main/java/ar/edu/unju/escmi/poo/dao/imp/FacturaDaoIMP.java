package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;

public class FacturaDaoIMP implements IFacturaDao{

	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void agregarFactura(Factura ticket) {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(ticket);
			manager.getTransaction().commit();
		}catch(Exception ime) {
			System.out.println(ime);
		}
	}

	@Override
	public List<Factura> mostrarFacturasPorCliente(Long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura buscarFacturaPorId(Long idTicket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Factura retornarFacturaPorCliente(Long dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarDetalle(Detalle detail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double calcularTotal(Factura ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularSubtotal(Factura ticket) {
		// TODO Auto-generated method stub
		return null;
	}

}
