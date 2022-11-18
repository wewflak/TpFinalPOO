package ar.edu.unju.escmi.poo.principal;

import java.time.LocalDate;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;
import ar.edu.unju.escmi.poo.dao.imp.ClienteDaoIMP;
import ar.edu.unju.escmi.poo.util.ClienteUtil;

public class Principal {

	public static void main(String[] args) {
		//ClienteUtil.cargarCliente();
		ClienteDaoIMP ClienteService = new ClienteDaoIMP();
		Rol rol = new Rol("dddd");
		Usuario usuario = new Usuario("aasss", "123", rol);
		Cliente cliente = new Cliente("ddd","aaaa", (long)5151, LocalDate.now(), usuario);
		ClienteService.agregarCliente(cliente, usuario, rol);
		Cliente clientBuscado= new Cliente();
		System.out.println(ClienteService.buscarCliente((long)5151).getApellido());
		ClienteService.obtenerClientes().stream().forEach(c-> System.out.println(c.getApellido()));
		
		
	}

}
