package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Comprobante;
import com.centroinformacion.repository.ComprobanteRepository;

@Service
public class ComprobanteServiceImpl implements ComprobanteService {
	
	@Autowired
	private ComprobanteRepository repository;

	@Override
	public List<Comprobante> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Comprobante insertaActualizaComprobante(Comprobante comprobante) {
		return repository.save(comprobante);
	}

	@Override
	public void eliminaComprobante(int idcomprobante) {
		repository.deleteById(idcomprobante);
	}

}
