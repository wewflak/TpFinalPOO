package ar.edu.unju.escmi.poo.components;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	@Id
	private Long codigoProducto;
	private String origen;
	private Double precioUnitario;
	private Integer descuento;
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	public Producto(String nombre, String descripcion, Long codigoProducto, String origen, Double precioUnitario,
			Integer descuento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigoProducto = codigoProducto;
		this.origen = origen;
		this.precioUnitario = precioUnitario;
		this.descuento = descuento;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", codigoProducto=" + codigoProducto
				+ ", origen=" + origen + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + "]";
	}
	
	
}
