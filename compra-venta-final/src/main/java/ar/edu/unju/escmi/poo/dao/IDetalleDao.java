package ar.edu.unju.escmi.poo.dao;

import ar.edu.unju.escmi.poo.components.Detalle;

public interface IDetalleDao {

	public void crearDetalle(Detalle detail);
	public Double calcularImporte(Detalle detail);
	public Detalle buscarDetalle(int id);
}
