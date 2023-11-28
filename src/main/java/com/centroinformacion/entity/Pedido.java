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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")
	private Integer idpedido;
	
	@Column(name = "estado")
	private String estado;
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fechaentrega") private Date fechaEntrega;
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fecharegistro") private Date fechaRegistro;
	 */
	
	/*
	 * @Temporal(TemporalType.TIME)
	 * 
	 * @JsonFormat(shape = JsonFormat.Shape.STRING) private Date horaEntrega;
	 */
	
	@Column(name = "lugar")
	private String lugarEntrega;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idcliente")
	private Cliente cliente;

}
