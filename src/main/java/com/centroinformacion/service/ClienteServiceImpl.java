package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Cliente;
import com.centroinformacion.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void eliminaCliente(int idcliente) {
		repository.deleteById(idcliente);
	}
	
	
}
