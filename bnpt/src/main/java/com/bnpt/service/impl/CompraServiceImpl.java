package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnpt.exception.GenericException;
import com.bnpt.model.entities.Compra;
import com.bnpt.model.entities.Credito;
import com.bnpt.model.repository.CompraRepository;
import com.bnpt.model.repository.CreditoRepository;
import com.bnpt.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

	@Autowired
	private CompraRepository CompraRepository;
	@Autowired
	private CreditoRepository CreditoRepository;
	
	@Override
	@Transactional
	public Compra registrar(Compra t) {
		if(t.getCredito().getCreditoRestante() - t.getPrecio() >= 0){
			Credito tempCredito = t.getCredito();
			tempCredito.setCreditoRestante(t.getCredito().getCreditoRestante() - t.getPrecio());
			CreditoRepository.save(tempCredito);

			return CompraRepository.save(t);
		}
		else{
			throw new GenericException("CreditoRestanteInsuficiente");
		}
	}

	//t ya viene con el status cambiado
	@Override
	public Compra modificar(Compra t) {
		Credito tempCredito = t.getCredito();
		tempCredito.setCreditoRestante(tempCredito.getCreditoRestante() + t.getPrecio());
		CreditoRepository.save(tempCredito);

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