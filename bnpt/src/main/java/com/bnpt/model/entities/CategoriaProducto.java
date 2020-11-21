package com.bnpt.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias_productos")
public class CategoriaProducto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "categoria", nullable = false, length = 15)
    private String categoria;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}