package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.components.Factura;

public interface IFacturaDao {

	public void agregarFactura(Factura ticket);
	public List<Factura> mostrarFacturasPorCliente(Long dni);
	public Factura buscarFacturaPorId(Long idTicket);
	public Factura retornarFacturaPorCliente(Long dni);
	
}
