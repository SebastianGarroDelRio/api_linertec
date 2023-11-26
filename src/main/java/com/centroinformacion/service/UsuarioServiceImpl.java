package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Usuario;
import com.centroinformacion.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public Usuario insertaActualizaUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public void eliminaUsuario(int idusuario) {
		repository.deleteById(idusuario);
	}
	
	@Override
	public Usuario findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username,password);
	}

	

}