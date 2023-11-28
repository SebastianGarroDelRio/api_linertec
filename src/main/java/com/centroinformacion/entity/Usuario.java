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
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Integer idusuario;
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fechanacimiento") private Date fechaNacimiento;
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fecharegistro") private Date fechaRegistro;
	 */
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idubigeo")
	private Ubigeo ubigeo;
	
	@ManyToOne
	@JoinColumn(name="iddocumento")
	private Documento documento;
	
}