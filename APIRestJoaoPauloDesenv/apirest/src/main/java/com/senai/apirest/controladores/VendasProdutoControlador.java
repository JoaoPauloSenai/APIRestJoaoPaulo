package com.senai.apirest.controladores;

import com.senai.apirest.entidades.VendasProduto;
import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.servicos.VendasProdutoServico;
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
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class VendasProdutoControlador {

    @Autowired
    private VendasProdutoServico vendasProdutoServico;

    // GET http://localhost:8010/apirest/vendasproduto/123
    @CrossOrigin(origins = "*")
    @GetMapping("/consulta/vendasproduto/{id}")
    public ResponseEntity<Object> consultaVendasProdutoPorId(@PathVariable(value = "id") Long idVendasProduto) {

        Optional<VendasProduto> vendasProduto = vendasProdutoServico.consultarVendasProduto(idVendasProduto);
        if (vendasProduto.isPresent()) {
            return new ResponseEntity<>(vendasProduto.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar VendasProduto");
            erro.setDescrição("Erro ao consultar VendasProduto ID: " + idVendasProduto);
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/vendasproduto")
    public ResponseEntity<Object> incluirVendasProduto(@Valid @RequestBody VendasProduto vendasProduto) {

        Long idVendasProduto = vendasProdutoServico.incluirVendasProduto(vendasProduto);
        if (idVendasProduto != null && idVendasProduto > 0) {
            return new ResponseEntity<>(idVendasProduto, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir VendasProduto");
            erro.setDescrição("Erro ao incluir VendasProduto!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/excluir/vendasproduto/{id}")
    public ResponseEntity<Object> excluirVendasProdutoPorId(@PathVariable(value = "id") long id) {
        if (vendasProdutoServico.excluirVendasProduto(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/atualizar/vendasproduto/{id}")
    public ResponseEntity<Object> atualizaVendasProdutoPorId(@Valid @RequestBody VendasProduto atualizaVendasProduto) {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualiza VendasProduto");
        Long idVendasProduto = vendasProdutoServico.atualizarVendasProduto(atualizaVendasProduto);
        if (idVendasProduto != null && idVendasProduto > 0) {
            msg.setDescrição("VendasProduto ID (" + idVendasProduto + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        msg.setDescrição("VendasProduto ID (" + idVendasProduto + ") erro ao atualizar VendasProduto!");
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}