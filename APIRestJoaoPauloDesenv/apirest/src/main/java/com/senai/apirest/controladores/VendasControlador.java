package com.senai.apirest.controladores;

import com.senai.apirest.entidades.Vendas;
import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.servicos.VendasServico;
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
public class VendasControlador {

    @Autowired
    private VendasServico vendasServico;

    // GET http://localhost:8010/apirest/vendas/123
    @CrossOrigin(origins = "*")
    @GetMapping("/consulta/vendas/{id}")
    public ResponseEntity<Object> consultaVendas(@PathVariable(value = "id") Long idVendas) {

        Optional<Vendas> vendas = vendasServico.consultarVendas(idVendas);
        if (vendas.isPresent()) {
            return new ResponseEntity<>(vendas.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Vendas");
            erro.setDescrição("Erro ao consultar Vendas ID: " + idVendas);
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/vendas", consumes = {"application/json"})
    public ResponseEntity<Object> incluirVendas(@Valid @RequestBody Vendas vendas) {

        Long idVds = vendasServico.incluirVendas(vendas);
        if (idVds != null && idVds > 0) {
            return new ResponseEntity<>(idVds, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Vendas");
            erro.setDescrição("Erro ao incluir Vendas!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/excluir/vendas/{id}")
    public ResponseEntity<Object> excluirVendas(@PathVariable(value = "id") long id) {
        if (vendasServico.excluirVendas(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/atualizar/vendas/{id}")
    public ResponseEntity<Object> atualizaVendas(@Valid @RequestBody Vendas atualizaVendas) {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualiza Vendas");
        Long idVendas = vendasServico.atualizarVendas(atualizaVendas);
        if (idVendas != null && idVendas > 0) {
            msg.setDescrição("Vendas ID (" + idVendas + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        msg.setDescrição("Vendas ID (" + idVendas + ") erro ao atualizar vendas!");
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}
