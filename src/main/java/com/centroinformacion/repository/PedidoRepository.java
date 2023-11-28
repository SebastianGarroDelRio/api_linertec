package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
