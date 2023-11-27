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

import com.centroinformacion.entity.Producto;
import com.centroinformacion.service.ProductoService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaProductos() {
		List<Producto> lista = service.listaTodos();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto producto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida =  service.insertaActualizaProducto(producto);
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
	
	@PutMapping("/ActualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto producto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida =  service.insertaActualizaProducto(producto);
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
	
	@DeleteMapping("/EliminaProducto/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProducto(@PathVariable("id") int idproducto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaProducto(idproducto);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}