package com.Exercicios.exerciciciossemana11.repository;

import com.Exercicios.exerciciciossemana11.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
