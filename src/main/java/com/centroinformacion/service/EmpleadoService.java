package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Empleado;

public interface EmpleadoService {
	
	public abstract List<Empleado> listaEmpleado();
	public abstract Empleado insertaActualizaEmpleado(Empleado empleado);
	public abstract void eliminaEmpleado(int idempleado);

}