package com.devinhouse.projetomarket.projectmarket.service;

import com.devinhouse.projetomarket.projectmarket.models.Categoria;
import com.devinhouse.projetomarket.projectmarket.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public Categoria salvaCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    public Categoria getCategoria(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new IllegalArgumentException("Categoria inexistente com esse ID");
    }

    public Categoria updateCategoria(Long id, Categoria categoria) {
        if (this.categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return this.categoriaRepository.save(categoria);
        }
        throw new IllegalArgumentException("Categoria inexistente com esse ID");
    }

    public void deleteCategoria(Long id) {
        this.categoriaRepository.deleteById(id);
    }
}

