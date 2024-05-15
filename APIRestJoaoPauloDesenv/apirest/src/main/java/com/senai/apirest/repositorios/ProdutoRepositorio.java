
package com.senai.apirest.repositorios;

import com.senai.apirest.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
