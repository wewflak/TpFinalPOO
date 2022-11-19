package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;

import ar.edu.unju.escmi.poo.components.Producto;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IProductoDao;

public class ProductoDaoIMP implements IProductoDao{
	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();
	
	@Override
	public void agregarProducto(Producto product) {
		// TODO Auto-generated method stub
		try {
			manager.getTransaction().begin();
			manager.persist(product);
			manager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Producto buscarProductoPorCodigo(Long codeProduct) {
		// TODO Auto-generated method stub
		return manager.find(Producto.class, codeProduct);
	}

	@Override
	public List<Producto> listarProductoPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		List<Producto> productos = (List<Producto>) manager.createQuery("SELECT p FROM Producto p").getResultList();
		return productos;
	}

	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		List<Producto> productos = (List<Producto>) manager.createQuery("SELECT p FROM Producto p").getResultList();
		return productos;
	}

}
