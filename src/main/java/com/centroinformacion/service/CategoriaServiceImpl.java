package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listaCategoria() {
		return repository.findAll();
	}

	@Override
	public Categoria insertaActualizaCategoria(Categoria categoria) {
		return repository.save(categoria);
	}

	@Override
	public void eliminaCategoria(int idcategoria) {
		repository.deleteById(idcategoria);
	}
	
}