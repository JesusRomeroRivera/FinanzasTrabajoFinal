package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.model.entities.Credito;
import com.bnpt.model.repository.CreditoRepository;
import com.bnpt.service.CreditoService;

@Service
public class CreditoServiceImpl implements CreditoService{

	@Autowired
	private CreditoRepository CreditoRepository;
	
	@Override
	public Credito registrar(Credito t) {
		return CreditoRepository.save(t);
	}

	@Override
	public Credito modificar(Credito t) {		
		return CreditoRepository.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		CreditoRepository.deleteById(id);
	}

	@Override
	public Optional<Credito> listId(Integer id) {
		return CreditoRepository.findById(id);
	}

	@Override
	public List<Credito> listar() {
		return CreditoRepository.findAll();
	}

	@Override
	public List<Credito> listarPorClienteId(String id) {
		return CreditoRepository.getCreditosCliente(id);
	}

	@Override
	public List<Credito> listarActivosPorClienteId(String id) {
		return CreditoRepository.getCreditosActivosCliente(id);
	}
}