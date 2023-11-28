package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Comprobante;

public interface ComprobanteService {
	
	public abstract List<Comprobante> listaTodos();
	public abstract Comprobante insertaActualizaComprobante(Comprobante comprobante);
	public abstract void eliminaComprobante(int idcomprobante);

}
