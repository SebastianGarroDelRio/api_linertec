package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Categoria;

public interface CategoriaService {
	
	public abstract List<Categoria> listaCategoria();
	public abstract Categoria insertaActualizaCategoria(Categoria categoria);
	public abstract void eliminaCategoria(int idcategoria);

}