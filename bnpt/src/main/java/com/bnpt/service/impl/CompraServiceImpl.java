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
		Credito tempCredito = CreditoRepository.findById(t.getCredito().getId()).get();
		System.out.println(t.getCredito().getCreditoRestante());
		if(tempCredito.getCreditoRestante() - t.getPrecio() >= 0){
			tempCredito.setCreditoRestante(tempCredito.getCreditoRestante() - t.getPrecio());

			return CompraRepository.save(t);
		}
		else{
			throw new GenericException("Credito restante insuficiente");
		}
	}

	@Override
	public Compra modificar(Compra t) {
		return CompraRepository.save(t);
	}

	@Override
	public Compra rechazarCompra(Integer id) {
		Compra compra = listId(id).get();

		if(compra.isStatusCompra() == false){
			throw new GenericException("Compra ya rechazada");
		}

		Credito tempCredito = CreditoRepository.findById(compra.getCredito().getId()).get();
		tempCredito.setCreditoRestante(tempCredito.getCreditoRestante() + compra.getPrecio());
		compra.setStatusCompra(false);

		return CompraRepository.save(compra);
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