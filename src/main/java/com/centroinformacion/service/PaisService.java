package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Pais;

public interface PaisService {
	
	public abstract List<Pais> listaTodos();
	public abstract Pais insertaActualizaPais(Pais pais);
	public abstract void eliminaPais(int idpais);
}
