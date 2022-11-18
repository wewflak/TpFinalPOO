package ar.edu.unju.escmi.poo.components;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Cliente clienteFactura;
	private LocalDate fechaFactura;
	@Id
	private Long codFactura;
	private Double subtotal;
	private Double Total;
	@OneToMany(mappedBy = "idDetalle", fetch=FetchType.EAGER)
	private List<Detalle> detalles = new ArrayList<Detalle>();
	public Factura() {
		// TODO Auto-generated constructor stub
	}
	public Cliente getClienteFactura() {
		return clienteFactura;
	}
	public void setClienteFactura(Cliente clienteFactura) {
		this.clienteFactura = clienteFactura;
	}
	public LocalDate getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(LocalDate fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Long getCodFactura() {
		return codFactura;
	}
	public void setCodFactura(Long codFactura) {
		this.codFactura = codFactura;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	public List<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	public Factura(Cliente clienteFactura, LocalDate fechaFactura, Long codFactura, Double subtotal, Double total,
			List<Detalle> detalles) {
		super();
		this.clienteFactura = clienteFactura;
		this.fechaFactura = fechaFactura;
		this.codFactura = codFactura;
		this.subtotal = subtotal;
		Total = total;
		this.detalles = detalles;
	}
	
}
