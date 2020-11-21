package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.TasaInteres;
import com.bnpt.model.repository.TasaInteresRepository;
import com.bnpt.service.TasaInteresService;

@Service
public class TasaInteresServiceImpl implements TasaInteresService{

	@Autowired
	private TasaInteresRepository TasaInteresRepository;
	
	@Override
	public TasaInteres registrar(TasaInteres t) {
		return TasaInteresRepository.save(t);
	}

	@Override
	public TasaInteres modificar(TasaInteres t) {		
		return TasaInteresRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		TasaInteresRepository.deleteById(id);
	}

	@Override
	public Optional<TasaInteres> listId(Integer id) {
		return TasaInteresRepository.findById(id);
	}

	@Override
	public List<TasaInteres> listar() {
		return TasaInteresRepository.findAll();
	}
}