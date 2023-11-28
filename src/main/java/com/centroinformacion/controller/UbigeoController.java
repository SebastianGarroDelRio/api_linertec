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

import com.centroinformacion.entity.Ubigeo;
import com.centroinformacion.service.UbigeoService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/ubigeo")
@CrossOrigin(origins = "*")
public class UbigeoController {
	
	@Autowired
	private UbigeoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaUbigeo() {
		List<Ubigeo> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Ubigeo>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraUbigeo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaUbigeo(@RequestBody Ubigeo ubigeo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Ubigeo objSalida = service.insertaActualizaUbigeo(ubigeo);
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

	@PutMapping("/ActualizaUbigeo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaUbigeo(@RequestBody Ubigeo ubigeo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Ubigeo objSalida = service.insertaActualizaUbigeo(ubigeo);
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

	@DeleteMapping("/EliminaUbigeo/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaUbigeo(@PathVariable("id") int idubigeo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaUbigeo(idubigeo);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
