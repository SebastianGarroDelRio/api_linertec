package com.centroinformacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "proveedores")
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproveedor")
	private Integer idproveedor;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "direccion")
	private String direccion;
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fecharegistro") private Date fechaRegistro;
	 */
	
	@Column(name = "numerodocumento", unique = true, nullable = false)
	private String numerodocumento;
	
	@ManyToOne
	@JoinColumn(name="iddocumento")
	private Documento documento;
	
	@ManyToOne
	@JoinColumn(name="idubigeo")
	private Ubigeo ubigeo;
	
}