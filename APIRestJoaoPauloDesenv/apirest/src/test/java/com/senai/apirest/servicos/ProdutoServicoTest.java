package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Produto;
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
public class ProdutoServicoTest {

    @Autowired
    private ProdutoServico srv;

    public ProdutoServicoTest() {
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
    public void testIncluirProduto() {
        System.out.println("incluirProduto");
        Produto produto = new Produto();
        produto.setNomeProduto("Nome do produto");
        produto.setValorProduto(10.0);
        produto.setDescricaoProduto("Descricao produto");
        Long result = srv.incluirProduto(produto);
        Long expResult = null;
        assertNotEquals(expResult, result);
    }
//
//    @Test
//    public void testIncluirProdutoSemNome() {
//        System.out.println("incluirProduto");
//        Produto produto = new Produto();
//        produto.setValorProduto(10.0);
//        produto.setDescricaoProduto("Descricao produto");
//        Long result = srv.incluirProduto(produto);
//        Long expResult = null;
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testExcluirProdutoIdNull() {
//        System.out.println("excluirCliente");
//        Boolean result = srv.excluirProduto(null);
//        assertFalse(result, "#2 Excluir Cliente ID nulo, ERRO: Excluiu Cliente");
//    }
//
//    @Test
//    public void testExcluirClienteComId() {
//        System.out.println("excluirCliente");
//        Long idProduto = 52L;
//        Boolean expResult = true;
//        Boolean result = srv.excluirProduto(idProduto);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testConsultarProduto() {
//        System.out.println("consultarProduto");
//        Long idProduto = 1L;
//        Optional<Produto> prd = srv.consultarProduto(idProduto);
//        assertNotEquals(null, prd.getClass());
//    }
//
//    @Test
//    public void testAtualizarProduto() {
//        System.out.println("atualizarProduto");
//        Produto produto = new Produto();
//        produto.setIDProduto(1L);
//        produto.setNomeProduto("Atualiza produto");
//        produto.setValorProduto(22.0);
//        produto.setDescricaoProduto("Nova Descricao do produto");
//        Boolean result = srv.atualizarProduto(produto);
//        assertTrue(result);
//    }
//
//    @Test
//    public void testListarProduto() {
//        System.out.println("listarProduto");
//        List<Produto> produto = srv.listarProduto();
//        assertNotNull(produto);
//        assertFalse(produto.isEmpty());
//    }
}
