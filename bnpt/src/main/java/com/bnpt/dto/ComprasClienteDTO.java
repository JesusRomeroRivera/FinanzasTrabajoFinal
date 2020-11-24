package com.bnpt.dto;

import java.util.List;

import com.bnpt.model.entities.Cliente;
import com.bnpt.model.entities.Compra;

public class ComprasClienteDTO {

	private Cliente cliente;
	private List<Compra> compras;

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public ComprasClienteDTO cliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	}

	public ComprasClienteDTO compras(List<Compra> compras) {
		this.compras = compras;
		return this;
	}
}
