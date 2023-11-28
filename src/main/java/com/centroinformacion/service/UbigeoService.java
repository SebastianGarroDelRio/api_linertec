package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Ubigeo;

public interface UbigeoService {
	
	public abstract List<Ubigeo> listaTodos();
	public abstract Ubigeo insertaActualizaUbigeo(Ubigeo ubigeo);
	public abstract void eliminaUbigeo(int idubigeo);

}
