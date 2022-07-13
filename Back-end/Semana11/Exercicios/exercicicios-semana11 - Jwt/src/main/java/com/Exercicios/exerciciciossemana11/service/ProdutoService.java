package com.Exercicios.exerciciciossemana11.service;

import com.Exercicios.exerciciciossemana11.model.Produto;
import com.Exercicios.exerciciciossemana11.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public void adiciona(Produto produto) {
        this.produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return this.produtoRepository.findById(id);
    }

    public void deleteById(Long id) {
        this.produtoRepository.deleteById(id);
    }

    public void update(Long id, Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);
    }


}
