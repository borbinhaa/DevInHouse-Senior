package com.Exercicios.exerciciciossemana11.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String descricao;
    @Column(name = "data_lancamento")
    @NotNull
    private LocalDate dataLancamento;
    @NotNull
    private Double preco;

}
