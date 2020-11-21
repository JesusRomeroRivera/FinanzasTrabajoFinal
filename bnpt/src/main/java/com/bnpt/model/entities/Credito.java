package com.bnpt.model.entities;

import java.time.LocalDateTime;
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

import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "creditos")
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
 
    @ManyToOne
    @JoinColumn(name = "tienda_id")
    Tienda tienda;
 
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "tasa_interes_id", nullable = false)
	private TasaInteres tasaInteres;

    @DecimalMin("0.00")
    @Column(name = "credito_inicial", nullable = false)
    private float creditoInicial;

    @DecimalMin("0.00")
    @Column(name = "credito_restante", nullable = false)
    private float creditoRestante;

	@JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaEmision;
    
	@JsonSerialize(using = ToStringSerializer.class)
    private LocalDateTime fechaVencimiento;
    
	@OneToMany(mappedBy = "credito", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.REMOVE }, fetch = FetchType.LAZY)
    private List<Compra> compras;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public TasaInteres getTasaInteres() {
        return this.tasaInteres;
    }

    public void setTasaInteres(TasaInteres tasaInteres) {
        this.tasaInteres = tasaInteres;
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
        this.fechaVencimiento = fechaVencimiento;
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}