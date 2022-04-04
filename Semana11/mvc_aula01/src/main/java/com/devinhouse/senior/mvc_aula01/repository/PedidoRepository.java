package com.devinhouse.senior.mvc_aula01.repository;

import com.devinhouse.senior.mvc_aula01.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
