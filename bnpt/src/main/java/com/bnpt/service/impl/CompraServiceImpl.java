package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.Compra;
import com.bnpt.model.repository.CompraRepository;
import com.bnpt.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository CompraRepository;
	
	@Override
	public Compra registrar(Compra t) {
		return CompraRepository.save(t);
	}

	@Override
	public Compra modificar(Compra t) {		
		return CompraRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		CompraRepository.deleteById(id);
	}

	@Override
	public Optional<Compra> listId(Integer id) {
		return CompraRepository.findById(id);
	}

	@Override
	public List<Compra> listar() {
		return CompraRepository.findAll();
	}
}