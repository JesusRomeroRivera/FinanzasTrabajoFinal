package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.Cliente;
import com.bnpt.model.repository.ClienteRepository;
import com.bnpt.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@Override
	public Cliente registrar(Cliente t) {
		return ClienteRepository.save(t);
	}

	@Override
	public Cliente modificar(Cliente t) {		
		return ClienteRepository.save(t);
	}

	@Override
	public void eliminar(String id) {
		ClienteRepository.deleteById(id);
	}

	@Override
	public Optional<Cliente> listId(String id) {
		return ClienteRepository.findById(id);
	}

	@Override
	public List<Cliente> listar() {
		return ClienteRepository.findAll();
	}
}