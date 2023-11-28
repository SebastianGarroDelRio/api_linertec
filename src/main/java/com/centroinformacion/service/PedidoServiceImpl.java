package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.centroinformacion.entity.Pedido;
import com.centroinformacion.repository.PedidoRepository;

public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository repository;

	@Override
	public List<Pedido> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Pedido insertaActualizaPedido(Pedido pedido) {
		return repository.save(pedido);
	}

	@Override
	public void eliminaPedido(int idpedido) {
		repository.deleteById(idpedido);
	}

}
