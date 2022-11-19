package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;

public interface IFacturaDao {

	public void agregarFactura(Factura ticket);
	public Factura mostrarFacturasPorCliente(Long dni, Long idTicket);
	public void mostrarFactura(Factura ticket);
	public void mostrarDetalle(Factura ticket);
	public Factura buscarFacturaPorId(Long idTicket);
	public List<Factura> retornarFacturaPorCliente(Long dni);
	public void agregarDetalle(Detalle detail, Factura ticket);
	public void calcularTotal(Factura ticket);
	public void calcularSubtotal(Factura ticket);
}
