package com.senai.apirest.controladores;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.entidades.MsgRetorno;
import com.senai.apirest.servicos.ClienteServico;
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
public class ClienteControlador {

    @Autowired
    private ClienteServico clienteservico;

    //GET  http://localhost:8010/apirest/cliente/12
    @CrossOrigin(origins = "*")
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> consultaClientePorId(@PathVariable(value = "id") Long idCliente) {

        Optional<Cliente> cliente = clienteservico.consultarCliente(idCliente);
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Cliente");
            erro.setDescrição("Erro ao consultar Cliente ID: " + idCliente);
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/cliente")
    public ResponseEntity<Object> ListarClientes() {

        List<Cliente> cliente = clienteservico.listarClientes();
        if (!cliente.isEmpty()) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Consultar Cliente");
            erro.setDescrição("Erro ao consultar Clientes");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/cliente")
    public ResponseEntity<Object> incluirCliente(@Valid @RequestBody Cliente cliente) {

        Long idCli = clienteservico.incluirCliente(cliente);
        if (idCli != null && idCli > 0) {
            return new ResponseEntity<>(idCli, HttpStatus.OK);
        } else {
            MsgRetorno erro = new MsgRetorno();
            erro.setFuncao("Incluir Cliente");
            erro.setDescrição("Erro ao incluir Cliente! Chame a TI!!");
            return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Object> excluirClientePorId(@PathVariable(value = "id") long id) {
        if (clienteservico.excluirCliente(id)) {

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value = "/cliente")
    public ResponseEntity<Object> atualizaClientePorId(@Valid @RequestBody Cliente Cli) {
        MsgRetorno msg = new MsgRetorno();
        msg.setFuncao("Atualiza Cliente");
        Long idCli = clienteservico.atualizarCliente(Cli);
        if (idCli != null && idCli > 0) {
            msg.setDescrição("Cliente IdCliente (" + idCli + ") atualizado com sucesso!");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        msg.setDescrição("Erro ao atualizar cliente!");
        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}
