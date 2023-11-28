package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Marca;
import com.centroinformacion.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaRepository repository;

	@Override
	public List<Marca> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Marca insertaActualizaMarca(Marca marca) {
		return repository.save(marca);
	}

	@Override
	public void eliminaMarca(int idmarca) {
		repository.deleteById(idmarca);
	}
	
}
