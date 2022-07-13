package com.devinhouse.projetomarket.projectmarket.repository;

import com.devinhouse.projetomarket.projectmarket.models.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
