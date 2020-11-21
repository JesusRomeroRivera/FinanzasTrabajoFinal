package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.CategoriaProducto;
import com.bnpt.model.repository.CategoriaProductoRepository;
import com.bnpt.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService{

	@Autowired
	private CategoriaProductoRepository CategoriaProductoRepository;
	
	@Override
	public CategoriaProducto registrar(CategoriaProducto t) {
		return CategoriaProductoRepository.save(t);
	}

	@Override
	public CategoriaProducto modificar(CategoriaProducto t) {		
		return CategoriaProductoRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		CategoriaProductoRepository.deleteById(id);
	}

	@Override
	public Optional<CategoriaProducto> listId(Integer id) {
		return CategoriaProductoRepository.findById(id);
	}

	@Override
	public List<CategoriaProducto> listar() {
		return CategoriaProductoRepository.findAll();
	}
}