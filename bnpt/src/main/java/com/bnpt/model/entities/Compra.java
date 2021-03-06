package com.bnpt.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "compras")
public class Compra {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "credito_id", nullable = false)
	private Credito credito;

	@Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;
	
	@DecimalMin("0.00")
    @Column(name = "precio", nullable = false)
    private float precio;
    
	@Column(name="fecha_pago",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;

    @Column(name = "tipo_moneda", nullable = false, length = 3)
	private String tipoMoneda;

	//1 -> Realiazada
	//0 -> No realizada
    @Column(name = "status_compra", nullable = false, length = 3)
	private Boolean statusCompra;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getTipoMoneda() {
		return this.tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Boolean isStatusCompra() {
		return this.statusCompra;
	}

	public Boolean getStatusCompra() {
		return this.statusCompra;
	}

	public void setStatusCompra(Boolean statusCompra) {
		this.statusCompra = statusCompra;
	}
}