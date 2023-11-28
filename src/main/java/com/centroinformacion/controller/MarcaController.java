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

import com.centroinformacion.entity.Marca;
import com.centroinformacion.service.MarcaService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
	
	@Autowired
	private MarcaService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaMarca() {
		List<Marca> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Marca>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraMarca")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMarca(@RequestBody Marca marca) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Marca objSalida = service.insertaActualizaMarca(marca);
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

	@PutMapping("/ActualizaMarca")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaMarca(@RequestBody Marca marca) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Marca objSalida = service.insertaActualizaMarca(marca);
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

	@DeleteMapping("/EliminaMarca/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaMarca(@PathVariable("id") int idmarca) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaMarca(idmarca);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
