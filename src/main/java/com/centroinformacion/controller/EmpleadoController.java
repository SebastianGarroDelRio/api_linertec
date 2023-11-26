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

import com.centroinformacion.entity.Empleado;
import com.centroinformacion.service.EmpleadoService;
import com.centroinformacion.util.Constantes;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> listaEmpleados() {
		List<Empleado> lista = service.listaEmpleado();
		if (lista.size() > 0) {
			return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<String>(Constantes.MENSAJE_NO_EXISTE_REGISTROS, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/RegistraEmpleado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEmpleado(@RequestBody Empleado empleado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Empleado objSalida = service.insertaActualizaEmpleado(empleado);
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

	@PutMapping("/ActualizaEmpleado")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEmpleado(@RequestBody Empleado empleado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Empleado objSalida = service.insertaActualizaEmpleado(empleado);
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

	@DeleteMapping("/EliminaEmpleado/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEmpleado(@PathVariable("id") int idempleado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminaEmpleado(idempleado);
			salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}