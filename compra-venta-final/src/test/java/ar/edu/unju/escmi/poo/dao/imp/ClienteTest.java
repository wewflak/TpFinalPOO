package ar.edu.unju.escmi.poo.dao.imp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Producto;
import ar.edu.unju.escmi.poo.components.Rol;
import ar.edu.unju.escmi.poo.components.Usuario;
import junit.framework.TestCase;

public class ClienteTest extends TestCase{
	ClienteDaoIMP clienteService;
	UsuarioDaoIMP usuarioService;
	RolDaoIMP rolService;
	Cliente cliente;
	@BeforeEach
	protected
	void setUp() throws Exception{
	System.out.println("Inicio Test");
	super.setUp();
	}
	@AfterEach
	protected
	void tearDown()throws Exception{
		System.out.println("Fin Test");
		super.tearDown();
	}
	@Test
	public void testComprobarCodigo() throws Exception {
		Rol unRol = new Rol("dddd");
		Usuario unUsuario = new Usuario("bbbb", "cccc", (long)5363, LocalDate.now(),"aaa", "ffff", unRol);
		rolService.agregarRol(unRol);
		usuarioService.agregarUsuario(unUsuario);
		assertNotNull(unUsuario);
	}
	@Test
	public void testCliente() {
		assertNotNull(usuarioService.buscarUsuarioDni((long)5151).getFechaDeN());
	}
}
