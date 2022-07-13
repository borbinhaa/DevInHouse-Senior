package org.senai.devinhouse.magazinesenaispringdata.service;

import lombok.AllArgsConstructor;
import org.senai.devinhouse.magazinesenaispringdata.model.Produto;
import org.senai.devinhouse.magazinesenaispringdata.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public Produto getProduto(long id) {
        Optional<Produto> produto = this.repository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        throw new IllegalArgumentException("Produto com esse id não existente");
    }

    public List<Produto> listaProdutos() {
        return (List<Produto>) this.repository.findAll();
    }

    public Produto salvaProduto(Produto produto) {
        return this.repository.save(produto);
    }

    public Produto alteraProduto(Long id, Produto produto) {
        if (repository.existsById(id)) {
            produto.setId(id);
            this.repository.save(produto);
        }
        return produto;
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public Produto encontraPelaDescricao(String descricao) {
        return this.repository.findByDescricao(descricao);
    }

    public Produto encontraPeloNome(String nome) {
        return this.repository.findByNome(nome);
    }
}
