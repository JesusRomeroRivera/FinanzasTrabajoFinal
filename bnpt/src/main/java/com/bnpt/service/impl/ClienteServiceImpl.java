package com.bnpt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;

import com.bnpt.exception.GenericException;
import com.bnpt.model.entities.Cliente;
import com.bnpt.model.entities.Tienda;
import com.bnpt.model.repository.ClienteRepository;
import com.bnpt.model.repository.TiendaRepository;
import com.bnpt.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository ClienteRepository;
	@Autowired
	private TiendaRepository TiendaRepository;

	@Override
	public Cliente registrar(Cliente t) {
		Optional<Cliente> cliente = ClienteRepository.getClienteByCorreo(t.getCorreo());
		Optional<Tienda> tienda = TiendaRepository.getTiendaByCorreo(t.getCorreo());

		if(cliente.isPresent() || tienda.isPresent()){
			throw new GenericException("Correo ya registrado");
		}

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

	@Override
	public Optional<Cliente> getClienteByCorreo(String correo){
		return ClienteRepository.getClienteByCorreo(correo);
	}

	@Override
	public Optional<Cliente> login(Cliente t){
		Optional<Cliente> cliente = ClienteRepository.getClienteByCorreo(t.getCorreo());

		if(!cliente.isPresent()){
			throw new GenericException("Correo no registrado");
		}

		if(!cliente.get().getPassword().equals(t.getPassword())){
			throw new GenericException("Contraseña inválida");
		}

		return cliente;
	}
}