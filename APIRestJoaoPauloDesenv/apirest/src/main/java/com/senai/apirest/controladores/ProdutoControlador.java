package com.senai.apirest.controladores;

import com.senai.apirest.entidades.Produto;
import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.servicos.ProdutoServico;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProdutoControlador {

    @Autowired
    private ProdutoServico produtoServico;

    // GET http://localhost:8010/apirest/produto/123
    @CrossOrigin(origins = "*")
    @GetMapping("/produto/{id}")
    public ResponseEntity<Object> consultaProdutoPorId(@PathVariable(value = "id") Long idProduto) {

        Optional<Produto> produto = produtoServico.consultarProduto(idProduto);
        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Produto");
            erro.setDescrição("Erro ao consultar Produto ID: " + idProduto);
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/produto")
    public ResponseEntity<Object> ListarProdutos() {

        List<Produto> produto = produtoServico.listarProduto();
        if (!produto.isEmpty()) {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Produto");
            erro.setDescrição("Erro ao consultar Produtos");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/produto")
    public ResponseEntity<Object> incluirProduto(@Valid @RequestBody Produto produto) {

        Long idProd = produtoServico.incluirProduto(produto);
        if (idProd != null && idProd > 0) {
            return new ResponseEntity<>(idProd, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Produto");
            erro.setDescrição("Erro ao incluir Produto! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/produto")
    public ResponseEntity<Object> excluirProdutoPorId(@PathVariable(value = "id") long id) {
        if (produtoServico.excluirProduto(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/produto")
    public ResponseEntity<Object> atualizaProdutoPorId(@Valid @RequestBody Produto produtoAtualizado) {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualizar Produto");
        Long idPro = produtoServico.atualizarProduto(produtoAtualizado);
        if (idPro != null && idPro > 0) {
            msg.setDescrição("Produto IdProduto (" + idPro + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        msg.setDescrição("Erro ao atualizar produto!");
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}
