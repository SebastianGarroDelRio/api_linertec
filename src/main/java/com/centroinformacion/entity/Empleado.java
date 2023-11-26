package com.centroinformacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleados")
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idempleado")
	private Integer idempleado;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "telefono", unique = true, nullable = false)
	private String telefono;
	
	@Column(name = "correo", unique = true, nullable = false)
	private String correo;
	
	@Column(name = "numerodocumento", unique = true, nullable = false)
	private String numerodocumento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="iddocumento")
	private Documento documento;

}