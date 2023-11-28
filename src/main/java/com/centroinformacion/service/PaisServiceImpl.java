package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Pais;
import com.centroinformacion.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository repository;

	@Override
	public List<Pais> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Pais insertaActualizaPais(Pais pais) {
		return repository.save(pais);
	}

	@Override
	public void eliminaPais(int idpais) {
		repository.deleteById(idpais);
	}

}
