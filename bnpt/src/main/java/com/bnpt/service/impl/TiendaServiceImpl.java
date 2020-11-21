package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.Tienda;
import com.bnpt.model.repository.TiendaRepository;
import com.bnpt.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	private TiendaRepository TiendaRepository;
	
	@Override
	public Tienda registrar(Tienda t) {
		return TiendaRepository.save(t);
	}

	@Override
	public Tienda modificar(Tienda t) {		
		return TiendaRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		TiendaRepository.deleteById(id);
	}

	@Override
	public Optional<Tienda> listId(Integer id) {
		return TiendaRepository.findById(id);
	}

	@Override
	public List<Tienda> listar() {
		return TiendaRepository.findAll();
	}
}