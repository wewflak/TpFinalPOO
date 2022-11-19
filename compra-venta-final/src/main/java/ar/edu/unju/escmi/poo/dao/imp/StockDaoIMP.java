package ar.edu.unju.escmi.poo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ar.edu.unju.escmi.poo.components.Stock;
import ar.edu.unju.escmi.poo.config.EmfSingleton;
import ar.edu.unju.escmi.poo.dao.IStockDao;

public class StockDaoIMP implements IStockDao{
	private static EntityManager manager =  EmfSingleton.getInstance().getEmf().createEntityManager();

	@Override
	public void agregarStock(Stock stock) {
		// TODO Auto-generated method stub
	try {
		manager.getTransaction().begin();
		manager.persist(stock);
		manager.getTransaction().commit();
	}catch(Exception ime) {
		System.out.println(ime);
	}
	}

	@Override
	public Stock buscarStock(Long idStock) {
		// TODO Auto-generated method stub
		return manager.find(Stock.class, idStock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> mostrarStocks() {
		// TODO Auto-generated method stub
		List<Stock> registros = (List<Stock>) manager.createQuery("SELECT s FROM Stock s").getResultList();
		return registros;
	}

	@Override
	public Stock buscarStockPorProducto(Long codProduct) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("SELECT s FROM Stock s " + " WHERE s.producto.codigoProducto = :codProduct");
      query.setParameter("codProduct", codProduct);
      return (Stock) query.getSingleResult();
	}

	@Override
	public void decrementarStockProducto(Stock stock, Integer quantity) {
		// TODO Auto-generated method stub
		stock.setCantidad(stock.getCantidad()-quantity);
		manager.getTransaction().begin();
		manager.refresh(stock);
		manager.getTransaction().commit();
		
	}
	
}
