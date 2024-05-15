package com.senai.apirest.servicos;

import com.senai.apirest.entidades.VendasProduto;
import com.senai.apirest.repositorios.VendasProdutoRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendasProdutoServico {

    @Autowired
    private VendasProdutoRepositorio vendasProdutoRepositorio;

    public Optional<VendasProduto> consultarVendasProduto(Long id) {
        return vendasProdutoRepositorio.findById(id);
    }

    public Long incluirVendasProduto(VendasProduto vendasProduto) {
        VendasProduto novoVendasProduto = vendasProdutoRepositorio.save(vendasProduto);
        return novoVendasProduto.getIDVendasProduto();
    }

    public boolean excluirVendasProduto(Long id) {
        if (vendasProdutoRepositorio.existsById(id)) {
            vendasProdutoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }

    public Long atualizarVendasProduto(VendasProduto vendasProduto) {
        if (vendasProdutoRepositorio.existsById(vendasProduto.getIDVendasProduto())) {
            VendasProduto atualizadoVendasProduto = vendasProdutoRepositorio.save(vendasProduto);
            return atualizadoVendasProduto.getIDVendasProduto();
        }
        return null;
    }
}
