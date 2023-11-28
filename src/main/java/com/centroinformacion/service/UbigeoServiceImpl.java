package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Proveedor;
import com.centroinformacion.entity.Ubigeo;
import com.centroinformacion.repository.UbigeoRepository;

@Service
public class UbigeoServiceImpl implements UbigeoService{
	
	@Autowired
	private UbigeoRepository repository;

	@Override
	public List<Ubigeo> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Ubigeo insertaActualizaUbigeo(Ubigeo ubigeo) {
		return repository.save(ubigeo);
	}

	@Override
	public void eliminaUbigeo(int idubigeo) {
		repository.deleteById(idubigeo);
	}
	
}
