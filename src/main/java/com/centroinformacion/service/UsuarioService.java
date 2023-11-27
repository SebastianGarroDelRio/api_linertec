package com.centroinformacion.service;

import java.util.List;

import com.centroinformacion.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Usuario> listaTodos();
	public abstract Usuario insertaActualizaUsuario(Usuario usuario);
	public abstract void eliminaUsuario(int idusuario);
	
	public abstract Usuario findByUsernameAndPassword(String username, String password);
	
}