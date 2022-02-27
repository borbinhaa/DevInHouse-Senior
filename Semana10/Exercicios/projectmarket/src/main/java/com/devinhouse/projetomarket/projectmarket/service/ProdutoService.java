package com.devinhouse.projetomarket.projectmarket.service;


import com.devinhouse.projetomarket.projectmarket.models.Produto;
import com.devinhouse.projetomarket.projectmarket.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto salvaProduto(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Produto getProduto(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        throw new IllegalArgumentException("Produto inexistente com esse ID");
    }

    public Produto updateProduto(Long id, Produto produto) {
        if (this.produtoRepository.existsById(id)) {
            produto.setId(id);
            return this.produtoRepository.save(produto);
        }
        throw new IllegalArgumentException("Produto inexistente com esse ID");
    }

    public void deleteProduto(Long id) {
        this.produtoRepository.deleteById(id);
    }
}
