package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Produto;
import com.senai.apirest.repositorios.ProdutoRepositorio;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public Long incluirProduto(Produto produto) {
        if (produto.getNomeProduto() != null) {
            return produtoRepositorio.save(produto).getIDProduto();
        } else {
            return null;
        }
    }

    public Boolean excluirProduto(Long idProduto) {

        try {
            produtoRepositorio.deleteById(idProduto);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir"
                    + " produto ID: " + idProduto
                    + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Produto> consultarProduto(Long idProduto) {

        return produtoRepositorio.findById(idProduto);
    }

    public List<Produto> listarProduto() {

        return produtoRepositorio.findAll();
    }

    @Transactional
    public Long atualizarProduto(Produto produtoAtualizado) {
        if (produtoAtualizado.getNomeProduto() == null) {
            return null;
        }
        if (produtoRepositorio.getReferenceById(produtoAtualizado.getIDCliente()) != null) {
            Produto pro = produtoRepositorio.getReferenceById(produtoAtualizado.getIDProduto());
            if (pro != null) {
                pro.setNomeProduto(produtoAtualizado.getNomeProduto());
                pro.setDescricaoProduto(produtoAtualizado.getDescricaoProduto());
                pro.setValorProduto(produtoAtualizado.getValorProduto());
                pro.setVendasProduto(produtoAtualizado.getVendasProduto());
                produtoRepositorio.save(pro);
                return pro.getIDProduto();
            }
        }
        return null;
    }
}
