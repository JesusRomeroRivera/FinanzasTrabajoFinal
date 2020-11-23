package com.bnpt.model.entities;

<<<<<<< HEAD
import java.util.Date;
=======
import java.time.LocalDateTime;
>>>>>>> master

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
=======
>>>>>>> master
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.DecimalMin;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> master

@Entity
@Table(name = "compras")
public class Compra {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

<<<<<<< HEAD
	@JsonBackReference
=======
	@JsonIgnore
>>>>>>> master
	@ManyToOne
	@JoinColumn(name = "credito_id", nullable = false)
	private Credito credito;

	@Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;
	
	@DecimalMin("0.00")
    @Column(name = "precio", nullable = false)
    private float precio;
    
<<<<<<< HEAD
	@Column(name="fecha_pago",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
=======
	@JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaPago;
>>>>>>> master

    @Column(name = "tipo_moneda", nullable = false, length = 3)
	private String tipoMoneda;

<<<<<<< HEAD
	//1 -> Realiazada
	//0 -> No realizada
    @Column(name = "status_compra", nullable = false, length = 3)
	private Boolean statusCompra;

=======
>>>>>>> master
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
	public Credito getCredito() {
		return this.credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

=======
>>>>>>> master
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

<<<<<<< HEAD
	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
=======
	public LocalDateTime getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
>>>>>>> master
		this.fechaPago = fechaPago;
	}

	public String getTipoMoneda() {
		return this.tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

<<<<<<< HEAD
	public Boolean isStatusCompra() {
		return this.statusCompra;
	}

	public Boolean getStatusCompra() {
		return this.statusCompra;
	}

	public void setStatusCompra(Boolean statusCompra) {
		this.statusCompra = statusCompra;
	}
=======
>>>>>>> master
}