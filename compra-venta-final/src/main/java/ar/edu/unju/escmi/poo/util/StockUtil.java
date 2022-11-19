package ar.edu.unju.escmi.poo.util;

import ar.edu.unju.escmi.poo.components.Stock;
import ar.edu.unju.escmi.poo.dao.imp.ProductoDaoIMP;
import ar.edu.unju.escmi.poo.dao.imp.StockDaoIMP;

public class StockUtil {
	StockDaoIMP stockService = new StockDaoIMP();

	public void inicializarStock() {
		ProductoDaoIMP productoService = new ProductoDaoIMP();
		productoService.listarProductos().stream().forEach(p-> stockService.agregarStock(new Stock(120, p)));
	}
	
	public StockUtil() {
		// TODO Auto-generated constructor stub
	}
}
