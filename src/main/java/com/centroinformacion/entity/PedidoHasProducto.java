package com.centroinformacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "pedidohasproducto")
public class PedidoHasProducto {

	
	@EmbeddedId
	private PedidoHasProductoPK pedidoHasProductoPK;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "precio")
	private double precio;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idpedido", nullable = false, insertable = false, updatable = false)
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

}