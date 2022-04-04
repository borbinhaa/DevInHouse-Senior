package com.devinhouse.senior.mvc_aula01.controller.dto;

import com.devinhouse.senior.mvc_aula01.model.Pedido;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class NovoPedidoDto {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String descricao;
    @NotNull @NotBlank
    private String valor;
    @CPF
    private String cpf;

    public Pedido converter() {
        Pedido pedido = new Pedido();
        pedido.setNome(nome);
        pedido.setDescricao(descricao);
        pedido.setValor(Double.parseDouble(valor));
        pedido.setDataPedido(LocalDate.now());
        return pedido;
    }

}
