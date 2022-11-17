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
		ClienteUtil.mostrarClientes();
		
	}

}
