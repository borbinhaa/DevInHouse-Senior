package org.senai.devinhouse.magazinesenaispringdata.repository;

import org.senai.devinhouse.magazinesenaispringdata.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    public Produto findByNome(String nome); //Query pela assinatura do metodo

    @Query(value = "select * from produtos where descricao = :descricao", nativeQuery = true)//, nativeQuery = true ; desse jeito poderia usar SQL e não JPQL
    public Produto findByDescricao(String descricao); // Query por anotacao e JPQL
}
