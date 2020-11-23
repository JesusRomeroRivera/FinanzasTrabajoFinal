package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.Producto;
import com.bnpt.model.repository.ProductoRepository;
import com.bnpt.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository ProductoRepository;
	
	@Override
	public Producto registrar(Producto t) {
		return ProductoRepository.save(t);
	}

	@Override
	public Producto modificar(Producto t) {		
		return ProductoRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		ProductoRepository.deleteById(id);
	}

	@Override
	public Optional<Producto> listId(Integer id) {
		return ProductoRepository.findById(id);
	}

	@Override
	public List<Producto> listar() {
		return ProductoRepository.findAll();
	}
}