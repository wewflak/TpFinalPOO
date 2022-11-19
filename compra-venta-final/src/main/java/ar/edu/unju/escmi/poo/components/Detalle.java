package ar.edu.unju.escmi.poo.components;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Detalle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idDetalle;
	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="idProducto")
	private Producto productoDetalle;
	private Integer descuentoDetalle;
	private Integer cantidadDetalle;
	private Double importeDetalle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idFactura")
	private Factura facturaDetalle;
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
	
	public Factura getFacturaDetalle() {
		return facturaDetalle;
	}
	public void setFacturaDetalle(Factura facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}
	public Detalle(Producto productoDetalle, Integer descuentoDetalle, Integer cantidadDetalle,
			Double importeDetalle, Factura facturaDetalle) {
		super();
		this.productoDetalle = productoDetalle;
		this.descuentoDetalle = descuentoDetalle;
		this.cantidadDetalle = cantidadDetalle;
		this.importeDetalle = importeDetalle;
		this.facturaDetalle = facturaDetalle;
	}
	
	
	
}
