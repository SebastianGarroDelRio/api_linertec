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

import com.centroinformacion.entity.Categoria;
import com.centroinformacion.service.CategoriaService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaCategorias() {
		List<Categoria> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Categoria>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraCategoria")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaCategoria(@RequestBody Categoria categoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Categoria objSalida =  service.insertaActualizaCategoria(categoria);
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
	
	@PutMapping("/ActualizaCategoria")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCategoria(@RequestBody Categoria categoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Categoria objSalida =  service.insertaActualizaCategoria(categoria);
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
	
	@DeleteMapping("/EliminaCategoria/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCategoria(@PathVariable("id") int idcategoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaCategoria(idcategoria);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}