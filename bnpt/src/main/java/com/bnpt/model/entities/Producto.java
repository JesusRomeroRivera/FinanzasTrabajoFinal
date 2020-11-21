package com.bnpt.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.DecimalMin;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
	@ManyToOne
	@JoinColumn(name = "categoria_producto_id", nullable = false)
	private CategoriaProducto categoriaProducto;

	@Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    
    @DecimalMin("0.00")
    @Column(name = "precio", nullable = false)
    private float precio;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoriaProducto getCategoriaProducto() {
        return this.categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}