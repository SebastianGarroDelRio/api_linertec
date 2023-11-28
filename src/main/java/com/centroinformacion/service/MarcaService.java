package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Marca;

public interface MarcaService {
	
	public abstract List<Marca> listaTodos();
	public abstract Marca insertaActualizaMarca(Marca marca);
	public abstract void eliminaMarca(int idmarca);
}
