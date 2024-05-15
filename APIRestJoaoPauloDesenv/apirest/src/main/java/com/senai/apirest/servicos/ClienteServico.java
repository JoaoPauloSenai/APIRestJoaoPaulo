package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.repositorios.ClienteRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Long incluirCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getCpf() == null) {
            return null;
        }

        return clienteRepositorio.save(cliente).getIDCliente();

    }

    public Boolean excluirCliente(Long idCliente) {

        try {
            if (clienteRepositorio.getReferenceById(idCliente).getIDCliente() != null) {
                clienteRepositorio.deleteById(idCliente);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao excluir"
                    + " cliente ID: " + idCliente
                    + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Cliente> consultarCliente(Long idCliente) {

        return clienteRepositorio.findById(idCliente);
    }

    public List<Cliente> listarClientes() {

        return clienteRepositorio.findAll();
    }

    @Transactional
    public Long atualizarCliente(Cliente clienteAtualizado) {
        if(clienteAtualizado.getNome() == null || clienteAtualizado.getCpf() == null){
            return null;
        }
        if (clienteRepositorio.getReferenceById(clienteAtualizado.getIDCliente()) != null) {
            Cliente cli = clienteRepositorio.getReferenceById(clienteAtualizado.getIDCliente());
            if (cli != null) {
                cli.setCpf(clienteAtualizado.getCpf());
                cli.setEmail(clienteAtualizado.getEmail());
                cli.setNome(clienteAtualizado.getNome());
                clienteRepositorio.save(cli);
                return cli.getIDCliente();
            }
        }
        return null;
    }
}
