package com.centroinformacion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Login;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.service.UsuarioService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaUsuarios() {
		List<Usuario> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaUsuario(@RequestBody Usuario usuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario objSalida =  service.insertaActualizaUsuario(usuario);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/ActualizaUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaUsuario(@RequestBody Usuario usuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario objSalida =  service.insertaActualizaUsuario(usuario);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/EliminaUsuario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaUsuario(@PathVariable("id") int idusuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaUsuario(idusuario);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody Login login){
		Usuario usuario = service.findByUsernameAndPassword(login.getUsername(),login.getPassword());
		if(usuario != null) {
			return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_AUTORIZADO, HttpStatus.NOT_FOUND);
	}
	
}