package com.Exercicios.exerciciciossemana11.controller.dto;

import com.Exercicios.exerciciciossemana11.model.Produto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
public class ProdutoFormDTO {

    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String descricao;
    @NotNull
    @NotBlank
    private String dataLancamento;
    @NotNull
    private Double preco;

    public static String localDatetoString(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return data.format(formatter);
    }

    public Produto toProduto() {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setDataLancamento(LocalDate.parse(dataLancamento));
        produto.setPreco(preco);
        return produto;
    }

    public void fromProduto(Produto produto) {
        this.setNome(produto.getNome());
        this.setDescricao(produto.getDescricao());
        this.setPreco(produto.getPreco());
        this.setDataLancamento(localDatetoString(produto.getDataLancamento()));
    }
}
