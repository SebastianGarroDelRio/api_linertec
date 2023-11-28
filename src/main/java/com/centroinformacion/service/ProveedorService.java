package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Proveedor;

public interface ProveedorService {
	
	public abstract List<Proveedor> listaTodos();
	public abstract Proveedor insertaActualizaProveedor(Proveedor proveedor);
	public abstract void eliminaProveedor(int idproveedor);

}