package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.components.Producto;

public interface IProductoDao {

	public void agregarProducto(Producto product);
	public Producto buscarProductoPorCodigo(Long codeProduct);
	public List<Producto> listarProductoPorCategoria(String categoria);
	public List<Producto> listarProductos();
}
