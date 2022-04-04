package com.devinhouse.senior.mvc_aula01.controller;

import com.devinhouse.senior.mvc_aula01.controller.dto.NovoPedidoDto;
import com.devinhouse.senior.mvc_aula01.model.Pedido;
import com.devinhouse.senior.mvc_aula01.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @GetMapping("/todos")
    public String listaPedidos(Model model) {
        List<Pedido> pedidos =  this.pedidoService.listPedidos();
        model.addAttribute("pedidos", pedidos);
        return "pedido";
    }

    @GetMapping("/formulario")
    public String formulario(NovoPedidoDto novoPedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid NovoPedidoDto novoPedidoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        this.pedidoService.adicionaPedido(novoPedidoDTO.converter());
        return "redirect:/pedido/todos";
    }
}
