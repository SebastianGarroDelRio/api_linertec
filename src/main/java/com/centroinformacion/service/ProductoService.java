package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto> listaTodos();
	public abstract Producto insertaActualizaProducto(Producto producto);
	public abstract void eliminaProducto(int idproducto);

}