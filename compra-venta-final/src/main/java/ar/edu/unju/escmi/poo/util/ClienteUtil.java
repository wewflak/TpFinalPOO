package ar.edu.unju.escmi.poo.util;

import java.time.LocalDate;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;
import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoIMP;

public class ClienteUtil {
	static ClienteDaoIMP ClienteService = new ClienteDaoIMP();
	public static void cargarCliente() {
	
	// TODO Auto-generated method stub
	System.out.println("aaaaaaaaaaaaaa");
	Rol rol = new Rol("dddd");
	Usuario usuario = new Usuario("aasss", "123", rol);
	Cliente cliente = new Cliente("ddd","aaaa", (long)5151, LocalDate.now(), usuario);
	ClienteService.agregarCliente(cliente, usuario, rol);
	}
	public static void mostrarClientes() {
		ClienteService.obtenerClientes();
	}
}
