
package com.senai.apirest.repositorios;

import com.senai.apirest.entidades.VendasProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasProdutoRepositorio
         extends JpaRepository<VendasProduto,Long> {    
}
