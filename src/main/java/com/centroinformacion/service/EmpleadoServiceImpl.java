package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Empleado;
import com.centroinformacion.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository repository;

	@Override
	public List<Empleado> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Empleado insertaActualizaEmpleado(Empleado empleado) {
		return repository.save(empleado);
	}

	@Override
	public void eliminaEmpleado(int idEmpleado) {
		repository.deleteById(idEmpleado);
	}

}