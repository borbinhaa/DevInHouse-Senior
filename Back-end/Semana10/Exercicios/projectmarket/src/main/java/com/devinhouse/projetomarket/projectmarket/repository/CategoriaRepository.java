package com.devinhouse.projetomarket.projectmarket.repository;

import com.devinhouse.projetomarket.projectmarket.models.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
