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

import com.centroinformacion.entity.Comprobante;
import com.centroinformacion.service.ComprobanteService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/comprobante")
@CrossOrigin(origins = "*")
public class ComprobanteController {
	
	@Autowired
	private ComprobanteService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaComprobante() {
		List<Comprobante> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Comprobante>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraComprobante")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaComprobante(@RequestBody Comprobante comprobante) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Comprobante objSalida = service.insertaActualizaComprobante(comprobante);
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

	@PutMapping("/ActualizaComprobante")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaComprobante(@RequestBody Comprobante comprobante) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Comprobante objSalida = service.insertaActualizaComprobante(comprobante);
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

	@DeleteMapping("/EliminaComprobante/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaComprobante(@PathVariable("id") int idcomprobante) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaComprobante(idcomprobante);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
