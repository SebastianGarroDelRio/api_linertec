package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente> listaTodos();
	public abstract Cliente insertaActualizaCliente(Cliente cliente);
	public abstract void eliminaCliente(int idcliente);

}
