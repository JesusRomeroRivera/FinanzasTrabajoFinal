package com.bnpt.model.entities;

<<<<<<< HEAD
import java.util.Date;
=======
import java.time.LocalDateTime;
>>>>>>> master
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
<<<<<<< HEAD
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonManagedReference;
=======

import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
>>>>>>> master

@Entity
@Table(name = "creditos")
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Integer id;
=======
    Long id;
>>>>>>> master
 
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    Tienda tienda;
 
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

<<<<<<< HEAD
	@Column(name = "tipo_tasa_interes", nullable = false, length = 3)
    private String tipoTasaInteres;
	
	@DecimalMin("0.00")
    @Column(name = "valor_tasa_interes", nullable = false)
    private float valorTasaInteres;
=======
	@ManyToOne
	@JoinColumn(name = "tasa_interes_id", nullable = false)
	private TasaInteres tasaInteres;
>>>>>>> master

    @DecimalMin("0.00")
    @Column(name = "credito_inicial", nullable = false)
    private float creditoInicial;

    @DecimalMin("0.00")
    @Column(name = "credito_restante", nullable = false)
    private float creditoRestante;

<<<<<<< HEAD
    @DecimalMin("0.00")
    @Column(name = "total_pagar", nullable = false)
    private float totalPagar;

    @DecimalMin("0.00")
    @Column(name = "mora", nullable = false)
    private float mora;

	@Column(name="fecha_emision",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    
	@Column(name="fecha_vencimiento",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    
    @JsonManagedReference
=======
	@JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaEmision;
    
	@JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaVencimiento;
    
>>>>>>> master
	@OneToMany(mappedBy = "credito", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REMOVE }, fetch = FetchType.LAZY)
    private List<Compra> compras;

<<<<<<< HEAD
	//1 -> Activo
	//0 -> No activo
    @Column(name = "status", nullable = false, length = 3)
    private Boolean status;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
=======
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
>>>>>>> master
        this.id = id;
    }

    public Tienda getTienda() {
        return this.tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

<<<<<<< HEAD
    public String getTipoTasaInteres() {
        return this.tipoTasaInteres;
    }

    public void setTipoTasaInteres(String tipoTasaInteres) {
        this.tipoTasaInteres = tipoTasaInteres;
    }

    public float getValorTasaInteres() {
        return this.valorTasaInteres;
    }

    public void setValorTasaInteres(float valorTasaInteres) {
        this.valorTasaInteres = valorTasaInteres;
=======
    public TasaInteres getTasaInteres() {
        return this.tasaInteres;
    }

    public void setTasaInteres(TasaInteres tasaInteres) {
        this.tasaInteres = tasaInteres;
>>>>>>> master
    }

    public float getCreditoInicial() {
        return this.creditoInicial;
    }

    public void setCreditoInicial(float creditoInicial) {
        this.creditoInicial = creditoInicial;
    }

    public float getCreditoRestante() {
        return this.creditoRestante;
    }

    public void setCreditoRestante(float creditoRestante) {
        this.creditoRestante = creditoRestante;
    }

<<<<<<< HEAD
    public float getTotalPagar() {
        return this.totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public float getMora() {
        return this.mora;
    }

    public void setMora(float mora) {
        this.mora = mora;
    }

    public Date getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
=======
    public LocalDateTime getFechaEmision() {
        return this.fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDateTime getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
>>>>>>> master
        this.fechaVencimiento = fechaVencimiento;
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
<<<<<<< HEAD

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
=======
>>>>>>> master
}