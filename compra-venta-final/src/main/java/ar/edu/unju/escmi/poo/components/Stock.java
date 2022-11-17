package ar.edu.unju.escmi.poo.components;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codStock;
	private Integer cantidad;
	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="idProducto")
	private Producto producto;
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getCodStock() {
		return codStock;
	}
	public void setCodStock(Long codStock) {
		this.codStock = codStock;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public Stock(Long codStock, Integer cantidad, Producto producto) {
		super();
		this.codStock = codStock;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	
	
}
