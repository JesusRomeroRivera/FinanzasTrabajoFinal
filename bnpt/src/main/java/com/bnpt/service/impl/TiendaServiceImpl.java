package com.bnpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpt.dto.ComprasClienteDTO;
import com.bnpt.exception.GenericException;
import com.bnpt.model.entities.Cliente;
import com.bnpt.model.entities.Compra;
import com.bnpt.model.entities.Credito;
import com.bnpt.model.entities.Tienda;
import com.bnpt.model.repository.TiendaRepository;
import com.bnpt.model.repository.ClienteRepository;
import com.bnpt.model.repository.CreditoRepository;
import com.bnpt.service.TiendaService;

@Service
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	private TiendaRepository TiendaRepository;
	@Autowired
	private ClienteRepository ClienteRepository;
	@Autowired
	private CreditoRepository CreditoRepository;
	
	@Override
	public Tienda registrar(Tienda t) {
		Optional<Tienda> tienda = TiendaRepository.getTiendaByCorreo(t.getCorreo());
		Optional<Cliente> cliente = ClienteRepository.getClienteByCorreo(t.getCorreo());

		if(cliente.isPresent() || tienda.isPresent()){
			throw new GenericException("Correo ya registrado");
		}

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

	@Override
	public Optional<Tienda> getTiendaByCorreo(String correo){
		return TiendaRepository.getTiendaByCorreo(correo);
	}

	@Override
	public Optional<Tienda> login(Tienda t){
		Optional<Tienda> tienda = TiendaRepository.getTiendaByCorreo(t.getCorreo());

		if(!tienda.isPresent()){
			throw new GenericException("Correo no registrado");
		}

		if(!tienda.get().getPassword().equals(t.getPassword())){
			throw new GenericException("Contraseña inválida");
		}

		return tienda;
	}

	@Override
	public List<ComprasClienteDTO> comprasClienteTienda(Tienda t){
		List<Credito> creditos = CreditoRepository.findAll();
		List<Credito> creditos_tiendas;
		List<ComprasClienteDTO> compras_dia;

		for(Credito c : creditos){
			if(c.getTienda().getId() == t.getId()){
				creditos_tiendas.add(c);
			}
		}

		ComprasClienteDTO tempCompraDia = new ComprasClienteDTO();

		for(Credito c : creditos_tiendas){
			for(Compra comp : c.getCompras()){
				//if(comp.getFechaPago() ){
					System.out.print(comp.getFechaPago());
					//List<Compra> temp = tempCompraDia.getCompras();
					//temp.add(comp);
					//tempCompraDia.setCompras(temp);
				//}
			}
			
			if(tempCompraDia.getCompras().isEmpty()){
				continue;
			}

			tempCompraDia = new ComprasClienteDTO()
			tempCompraDia.setCliente(c.getCliente());
			compras_dia.add(tempCompraDia);
		}

		return compras_dia;
	}
}