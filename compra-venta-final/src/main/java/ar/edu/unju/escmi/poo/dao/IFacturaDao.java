package ar.edu.unju.escmi.poo.dao;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.escmi.poo.components.Detalle;
import ar.edu.unju.escmi.poo.components.Factura;

public interface IFacturaDao {

	public void agregarFactura(Factura ticket) throws Exception;
	public Factura mostrarFacturasPorCliente(Long dni, Long idTicket);
	public void mostrarFactura(Factura ticket);
	public void mostrarDetalle(Factura ticket);
	public Factura buscarFacturaPorId(Long idTicket);
	public List<Factura> retornarFacturaPorCliente(Long dni);
	public void agregarDetalle(List<Detalle> details, Factura ticket);
	public void calcularTotal(Factura ticket);
	public void calcularSubtotal(Factura ticket);
	public Optional<Factura> comprobarExistenciaNroFactura(Long idTicket);
	public Optional<Detalle> comprobarExistenciaDetalle(Long codProducto, Factura ticket);
	
}
