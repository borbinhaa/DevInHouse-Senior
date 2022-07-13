package org.senai.devinhouse.magazinesenaispringdata.controller;

import lombok.AllArgsConstructor;
import org.senai.devinhouse.magazinesenaispringdata.model.Produto;
import org.senai.devinhouse.magazinesenaispringdata.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService service;


    @GetMapping("/")
    public List<Produto> listaProduto() {
        return this.service.listaProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProduto(@PathVariable Long id) {
        return this.service.getProduto(id);
    }

    @GetMapping("/descricao/{descricao}")
    public Produto encontraPelaDescricao(@PathVariable String descricao) {
        return this.service.encontraPelaDescricao(descricao);
    }

    @GetMapping("/nome/{nome}")
    public Produto encontraPeloNome(@PathVariable String nome) {
        return this.service.encontraPeloNome(nome);
    }

    @PostMapping("/")
    public Produto addProduto(@RequestBody Produto produto) {
        return this.service.salvaProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto addProduto(@PathVariable long id,@RequestBody Produto produto) {
        return this.service.alteraProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable long id) {
        this.service.delete(id);
    }
}
