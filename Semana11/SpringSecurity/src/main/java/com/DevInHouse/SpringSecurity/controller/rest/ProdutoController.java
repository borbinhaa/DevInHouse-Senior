package com.DevInHouse.SpringSecurity.controller.rest;

import com.DevInHouse.SpringSecurity.controller.dto.NovoProdutoDto;
import com.DevInHouse.SpringSecurity.model.Produto;
import com.DevInHouse.SpringSecurity.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtoOld")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @GetMapping
    public String produto(){
        return "Produto";
    }

    // localhost:8080/produto/todos
    @GetMapping("/todos")
    public List<Produto> listarProdutos(){
        return service.listaProdutos();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody NovoProdutoDto produtoDto){
        return service.adicionaProduto(produtoDto.converter());
    }

    // localhost:8080/produto/3
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id,@RequestBody NovoProdutoDto produtoDto){
        return service.atualizaProduto(id, produtoDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        service.deletaProduto(id);
    }
}
