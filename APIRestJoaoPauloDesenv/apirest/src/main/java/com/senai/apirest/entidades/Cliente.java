
package com.senai.apirest.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Table(name = "clientes")
@Entity()
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long IDCliente;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = true)
    private String email;

    @OneToMany(mappedBy="cliente",
               fetch=FetchType.LAZY,
               orphanRemoval = true,
               cascade = CascadeType.ALL)
    @Column(nullable = true)
    @JsonManagedReference(value="cliente-vendas")
    private Set<Vendas> vendas;
        
    public Long getIDCliente() {
        return IDCliente;
    }

    public Set<Vendas> getVendas() {
        return vendas;
    }

    public void setVendas(Set<Vendas> vendas) {
        this.vendas = vendas;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setIDCliente(Long IDCliente) {
        this.IDCliente = IDCliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
