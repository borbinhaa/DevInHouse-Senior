package com.DevInHouse.SpringSecurity.controller.mvc;


import com.DevInHouse.SpringSecurity.controller.dto.NovoProdutoDto;
import com.DevInHouse.SpringSecurity.model.Produto;
import com.DevInHouse.SpringSecurity.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProdutoControllerMvc {

    private final ProdutoService service;

    public ProdutoControllerMvc(ProdutoService service){
        this.service = service;
    }


    @GetMapping("/produto")
    public String helloMvc(){
        return "hello";
    }

    @GetMapping("/lista")
    public String listarProdutos(Model model){
        List<Produto> produtos = service.listaProdutos();
        model.addAttribute("produtos",produtos);
        return "produto/lista";
    }

    @GetMapping("/formulario")
    public String formularioProduto(NovoProdutoDto novoProdutoDto){
        return "produto/formulario";
    }

    @PostMapping("/novo")
    public String adicionarProduto(@Valid NovoProdutoDto novoProdutoDto,
                                   BindingResult result)
    {
        System.out.println(novoProdutoDto);
        if (result.hasErrors())
            return "produto/formulario";
        service.adicionaProduto(novoProdutoDto.converter());
        return "redirect:/lista";
    }

}
