package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Pedido;

public interface PedidoService {
	
	public abstract List<Pedido> listaTodos();
	public abstract Pedido insertaActualizaPedido(Pedido pedido);
	public abstract void eliminaPedido(int idpedido);
}
