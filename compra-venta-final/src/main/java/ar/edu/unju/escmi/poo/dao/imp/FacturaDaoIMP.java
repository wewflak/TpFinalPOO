package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.exception.ConstraintViolationException;

import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IFacturaDao;
import ar.edu.unju.escmi.poo.util.FechaUtil;

public class FacturaDaoIMP implements IFacturaDao{

	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void agregarFactura(Factura ticket) throws Exception {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(ticket);
			manager.getTransaction().commit();
		}catch(Exception ime) {
		if(ime instanceof PersistenceException) {
			throw new Exception("Ya existe una factura con ese codigo");
		}else if(ime instanceof ConstraintViolationException) {
			System.out.println("bbbbbbbbbbbbbbbbbbb");
		}
		}
	}

	@Override
	public Factura mostrarFacturasPorCliente(Long dni, Long idTicket) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT f FROM Factura f " + " WHERE f.clienteFactura.dni = :dni AND f.codFactura = :idTicket");
		query.setParameter("dni", dni);
		query.setParameter("idTicket", idTicket);
		return (Factura) query.getSingleResult();
	}

	@Override
	public Factura buscarFacturaPorId(Long idTicket) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT f FROM Factura f " + " WHERE f.codFactura = :idTicket");
		query.setParameter("idTicket", idTicket);
		return (Factura) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> retornarFacturaPorCliente(Long dni) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT f FROM Factura f " + " WHERE f.clienteFactura.dni = :dni");
		query.setParameter("dni", dni);
		return (List<Factura>) query.getResultList();
	}

	@Override
	public void agregarDetalle(Detalle detail, Factura ticket) {
		// TODO Auto-generated method stub
		ticket.getDetalles().add(detail);
		
	}

	@Override
	public void calcularTotal(Factura ticket) {
		// TODO Auto-generated method stub
		List<Detalle> detalles = ticket.getDetalles();
		double total=0;
		double importeDetalle=0;
		for(int i=0; i<detalles.size();i++) {
			importeDetalle = detalles.get(i).getImporteDetalle();
			total += importeDetalle;
		}
		ticket.setTotal(total);
		manager.getTransaction().begin();
		manager.refresh(ticket);
		manager.getTransaction().commit();
	}

	@Override
	public void calcularSubtotal(Factura ticket) {
		// TODO Auto-generated method stub
		List<Detalle> detalles = ticket.getDetalles();
		double subtotal=0;
		double importeDetalle=0;
		for(int i=0; i<detalles.size();i++) {
			subtotal += detalles.get(i).getImporteDetalle();
		}
		ticket.setSubtotal(subtotal);
		manager.getTransaction().begin();
		manager.refresh(ticket);
		manager.getTransaction().commit();
	}

	@Override
	public void mostrarFactura(Factura ticket) {
		// TODO Auto-generated method stub
		
			System.out.println("Numero: " + ticket.getCodFactura() + "                             .... Fecha ..../ " + FechaUtil.convertirLocalDateString(ticket.getFechaFactura()));
			System.out.println("N y A: " + ticket.getClienteFactura().getNombre()+ " " +ticket.getClienteFactura().getApellido() + "  DNI:" + ticket.getClienteFactura().getDni());
			System.out.println("Nombre Producto                            Descripcion                    Cantidad                     Importe");
			System.out.println("_________________________________________________________________\n"); 
			mostrarDetalle(ticket);
			System.out.println("_________________________________________________________________");
			System.out.println("                                        Subtotal: "+ ticket.getTotal());
			System.out.println("_________________________________________________________________");
			System.out.println(                                         "Total: " + ticket.getSubtotal());
		
	}

	@Override
	public void mostrarDetalle(Factura ticket) {
		// TODO Auto-generated method stub
				List<Detalle> detalles = ticket.getDetalles();
				String[] datos = new String [120];
		for(int i=0; i<detalles.size(); i++) {
			if(detalles.get(i)!=null) {
				datos[i] = detalles.get(i).getProductoDetalle().getNombre() + "    " + detalles.get(i).getProductoDetalle().getDescripcion() + "    " + detalles.get(i).getCantidadDetalle() + "    " +detalles.get(i).getImporteDetalle();
				System.out.println("_______________________________________________________\n"+ datos[i]);
			}else {
				System.out.println("   ");
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Factura> comprobarExistenciaNroFactura(Long idTicket) {
		// TODO Auto-generated method stub
		Optional<Factura> encontrado = Optional.empty();
		Query query = manager.createQuery("SELECT f FROM Factura f " + " WHERE f.codFactura = :idTicket");
		query.setParameter("idTicket", idTicket);
		List<Factura> facturas = (List<Factura>) query.getResultList();
		encontrado = facturas.stream().filter(f-> f.getCodFactura().equals(idTicket)).findFirst();
		return encontrado;
	}

	@Override
	public Optional<Detalle> comprobarExistenciaDetalle(Long codProducto, Factura ticket) {
		// TODO Auto-generated method stub
		Optional<Detalle> encontrado = Optional.empty();
		encontrado = ticket.getDetalles().stream().filter(d-> d.getProductoDetalle().getCodigoProducto().equals(codProducto)).findFirst();
		return encontrado;
	}
}
