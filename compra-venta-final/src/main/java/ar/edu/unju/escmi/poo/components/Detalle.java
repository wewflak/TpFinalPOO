package ar.edu.unju.escmi.poo.components;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="idProducto")
	private Producto productoDetalle;
	private Integer descuentoDetalle;
	private Integer cantidadDetalle;
	private Double importeDetalle;
	public Detalle() {
		// TODO Auto-generated constructor stub
	}
	public Producto getProductoDetalle() {
		return productoDetalle;
	}
	public void setProductoDetalle(Producto productoDetalle) {
		this.productoDetalle = productoDetalle;
	}
	public Integer getDescuentoDetalle() {
		return descuentoDetalle;
	}
	public void setDescuentoDetalle(Integer descuentoDetalle) {
		this.descuentoDetalle = descuentoDetalle;
	}
	public Integer getCantidadDetalle() {
		return cantidadDetalle;
	}
	public void setCantidadDetalle(Integer cantidadDetalle) {
		this.cantidadDetalle = cantidadDetalle;
	}
	public Double getImporteDetalle() {
		return importeDetalle;
	}
	public void setImporteDetalle(Double importeDetalle) {
		this.importeDetalle = importeDetalle;
	}
	public Detalle(Producto productoDetalle, Integer descuentoDetalle, Integer cantidadDetalle, Double importeDetalle) {
		super();
		this.productoDetalle = productoDetalle;
		this.descuentoDetalle = descuentoDetalle;
		this.cantidadDetalle = cantidadDetalle;
		this.importeDetalle = importeDetalle;
	}
	
	
}
