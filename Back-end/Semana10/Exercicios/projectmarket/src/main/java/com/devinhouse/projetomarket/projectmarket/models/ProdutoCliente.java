package com.devinhouse.projetomarket.projectmarket.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "produto_cliente")
public class ProdutoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_cliente")
    private long idClient;
    @Column(name = "id_produto")
    private long idProduto;

    public ProdutoCliente() {

    }
}

