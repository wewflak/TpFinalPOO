package ar.edu.unju.escmi.poo.dao.imp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.poo.components.Cliente;
import ar.edu.unju.escmi.poo.components.Usuario;

public class ClienteDaoIMPTest {

    private UsuarioDaoIMP usuarioService = new UsuarioDaoIMP();

    List<Usuario> getUsers() {
        return usuarioService.obtenerUsuarios();
    }

    @Test
    void testObtenerClientes() {
        assertNotNull(getUsers());
    }
    
    @Test
    void testAgregarCliente() {
        List<Usuario> test = new ArrayList<>();
        getUsers().forEach(user -> {
            try {
                usuarioService.agregarUsuario(user);
                test.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        assertNotNull(test);
    }

    @Test
    void testBuscarCliente() {
        assertTrue(usuarioService.buscarUsuarioDni(1L) == getUsers().get(1));
    }
}
