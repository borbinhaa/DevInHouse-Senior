package com.DevInHouse.SpringSecurity.repository;

import com.DevInHouse.SpringSecurity.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public Produto findByNome(String nome);
}
