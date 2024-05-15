package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.entidades.Vendas;
import com.senai.apirest.repositorios.VendasRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasServico {

    @Autowired
    private VendasRepositorio vendasRepositorio;
    private ClienteServico clienteServico;

    public Long incluirVendas(Vendas vendas, Long idCliente) {
        Cliente cli = clienteServico.consultarCliente(idCliente).get();
        if (cli != null) {
            vendas.setCliente(cli);
            return vendasRepositorio.save(vendas).getIDVendas();
        }
        else {
            return null;
        }
    }

    public Boolean excluirVendas(Long idVendas) {

        try {
            vendasRepositorio.deleteById(idVendas);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir"
                    + " vendas ID: " + idVendas
                    + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Vendas> consultarVendas(Long idVendas) {

        return vendasRepositorio.findById(idVendas);
    }

    public List<Vendas> listarVendas() {

        return vendasRepositorio.findAll();
    }

    @Transactional
    public Boolean atualizarCliente(Vendas vendas) {

        Vendas vds = vendasRepositorio.getReferenceById(vendas.getIDVendas());
        if (vds != null) {
            vds.setStatus(vendas.getStatus());
            vendasRepositorio.save(vds);
            return true;
        } else {
            return false;
        }
    }

    public Long atualizarVendas(Vendas atualizaVendas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long incluirVendas(Vendas vendas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
