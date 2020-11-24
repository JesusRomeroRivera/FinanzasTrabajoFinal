package com.bnpt.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
    @Column(name = "documento", columnDefinition = "text", nullable = false, length = 8)
    private String documento;
    
	@Column(name = "categoria_documento", nullable = false, length = 3)
	private String categoriaDocumento;

	@Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "password", nullable = false, length = 256)
	private String password;

	public String getId() {
		return this.documento;
	}

	public void setId(String documento) {
		this.documento = documento;
	}

	public String getCategoriaDocumento() {
		return this.categoriaDocumento;
	}

	public void setCategoriaDocumento(String categoriaDocumento) {
		this.categoriaDocumento = categoriaDocumento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}