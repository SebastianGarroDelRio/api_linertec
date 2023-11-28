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

import com.centroinformacion.entity.Pais;
import com.centroinformacion.service.PaisService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin("*")
public class PaisController {
	
	@Autowired
	private PaisService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaPais() {
		List<Pais> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Pais>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraPais")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPais(@RequestBody Pais pais) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Pais objSalida = service.insertaActualizaPais(pais);
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

	@PutMapping("/ActualizaPais")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPais(@RequestBody Pais pais) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Pais objSalida = service.insertaActualizaPais(pais);
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

	@DeleteMapping("/EliminaPais/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaPais(@PathVariable("id") int idpais) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaPais(idpais);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
