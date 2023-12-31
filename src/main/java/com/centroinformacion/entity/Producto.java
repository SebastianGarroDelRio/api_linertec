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
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto")
	private Integer idproducto;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "estado")
	private int estado;
	
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fechavigencia") private Date fechaVigencia;
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "fecharegistro") private Date fechaRegistro;
	 */
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "serie")
	private String serie;
	
	@Column(name = "stock")
	private String stock;
	
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="idmarca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name="idpais")
	private Pais pais;

}