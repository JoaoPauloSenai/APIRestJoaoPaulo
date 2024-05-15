/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteServicoTest {

    @Autowired
    private ClienteServico srv;

    public ClienteServicoTest() {

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test

    public void testIncluirCliente() {
        System.out.println("incluirCliente");
        Cliente cliente = new Cliente();
        cliente.setNome("Paulo");
        cliente.setCpf("12345678901");
        cliente.setEmail("joao@hotmail.com");
        Long expResult = null;
        Long result = srv.incluirCliente(cliente);
        assertNotEquals(expResult, result);
    }
//
//    @Test
//
//    public void testIncluirClienteSemCPF() {
//        System.out.println("incluirCliente");
//        Cliente cliente = new Cliente();
//        cliente.setNome("Paulo");
//        cliente.setEmail("joao@hotmail.com");
//        Long expResult = null;
//        Long result = srv.incluirCliente(cliente);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//
//    public void testIncluirClienteSemNome() {
//        System.out.println("incluirCliente");
//        Cliente cliente = new Cliente();
//        cliente.setCpf("12345678901");
//        cliente.setEmail("joao@hotmail.com");
//        Long expResult = null;
//        Long result = srv.incluirCliente(cliente);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testExcluirClienteIdNull() {
//        System.out.println("excluirCliente");
//        Long idCliente = null;
//        Boolean expResult = true;
//        Boolean result = srv.excluirCliente(idCliente);
//        assertNotEquals(expResult, result);
//    }
//
//    @Test
//    public void testExcluirClienteComId() {
//        System.out.println("excluirCliente");
//        Long idCliente = 2L;
//        Boolean expResult = true;
//        Boolean result = srv.excluirCliente(idCliente);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testConsultarClientePeloID() {
//        System.out.println("consultarCliente");
//        Long idCliente = 1L;
//        Optional<Cliente> cli = srv.consultarCliente(idCliente);
////      Optional<Cliente> result = null;
//        assertNotEquals(null, cli.get());
//    }
//
//    @Test
//    public void testAtualizarCliente() {
//        System.out.println("atualizarCliente");
//        Cliente cliente = new Cliente();
//        cliente.setNome("Pedro Paulo");
//        cliente.setCpf("12345678922");
//        cliente.setEmail("Paulo@hotmail.com");
//        cliente.setIDCliente(1L);
//        Boolean result = srv.atualizarCliente(cliente);
//        assertTrue(result);
//    }
//
//    @Test
//    public void testListarClientes() {
//        System.out.println("listarClientes");
//        List<Cliente> clientes = srv.listarClientes();
//        assertNotNull(clientes);
//        assertFalse(clientes.isEmpty());
//    }
}
