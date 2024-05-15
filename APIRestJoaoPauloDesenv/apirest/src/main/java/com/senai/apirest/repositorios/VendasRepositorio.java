
package com.senai.apirest.repositorios;

import com.senai.apirest.entidades.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepositorio extends JpaRepository<Vendas,Long> {
    
}
