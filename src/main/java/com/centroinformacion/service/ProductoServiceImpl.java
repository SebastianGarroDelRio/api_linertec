package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Producto;
import com.centroinformacion.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public Producto insertaActualizaProducto(Producto producto) {
		return repository.save(producto);
	}

	@Override
	public void eliminaProducto(int idproducto) {
		repository.deleteById(idproducto);
	}
}