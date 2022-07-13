package com.devinhouse.projetomarket.projectmarket.repository;

import com.devinhouse.projetomarket.projectmarket.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
