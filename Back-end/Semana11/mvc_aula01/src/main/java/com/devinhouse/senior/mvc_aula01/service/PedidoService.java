package com.devinhouse.senior.mvc_aula01.service;

import com.devinhouse.senior.mvc_aula01.model.Pedido;
import com.devinhouse.senior.mvc_aula01.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public List<Pedido> listPedidos() {
        return this.pedidoRepository.findAll();
    }

    public Pedido adicionaPedido(Pedido pedido) {
        return this.pedidoRepository.save(pedido);
    }
}
