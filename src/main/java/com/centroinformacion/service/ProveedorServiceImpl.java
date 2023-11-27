package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Proveedor insertaActualizaProveedor(Proveedor proveedor) {
		return repository.save(proveedor);
	}

	@Override
	public void eliminaProveedor(int idproveedor) {
		repository.deleteById(idproveedor);
	}

}