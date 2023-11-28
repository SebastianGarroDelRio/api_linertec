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

import com.centroinformacion.entity.Pedido;
import com.centroinformacion.service.PedidoService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {
	
	@Autowired
	private PedidoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaPedido() {
		List<Pedido> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraPedido")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaPedido(@RequestBody Pedido pedido) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Pedido objSalida = service.insertaActualizaPedido(pedido);
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

	@PutMapping("/ActualizaPedido")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaPedido(@RequestBody Pedido pedido) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Pedido objSalida = service.insertaActualizaPedido(pedido);
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

	@DeleteMapping("/EliminaPedido/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaPedido(@PathVariable("id") int idpedido) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaPedido(idpedido);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
