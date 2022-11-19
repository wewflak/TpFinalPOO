package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.components.Stock;

public interface IStockDao {

	public void agregarStock(Stock stock);
	public Stock buscarStock(Long idStock);
	public List<Stock> mostrarStocks();
	public Stock buscarStockPorProducto(Long codProduct);
	public void decrementarStockProducto(Stock stock, Integer quantity);
}
