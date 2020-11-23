package com.bnpt.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bnpt.exception.ModeloNotFoundException;
import com.bnpt.model.entities.Cliente;
import com.bnpt.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
	@Autowired
	private ClienteService ClienteService;
	
	@ApiOperation("Retorna una lista de Clientes")
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> Clientes = new ArrayList<>();
		Clientes = ClienteService.listar();
		return new ResponseEntity<List<Cliente>>(Clientes, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la Cliente correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> listarId(@PathVariable("id") String id) {
		Optional<Cliente> Cliente = ClienteService.listId(id);
		if (!Cliente.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Cliente>(Cliente.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una Cliente")
	@PostMapping
	public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente Cliente){
		Cliente ClienteNew = new Cliente();
		ClienteNew = ClienteService.registrar(Cliente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ClienteNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}

	@ApiOperation("Logea un cliente")
	@PostMapping(value = "/login")
	public ResponseEntity<Cliente> login(@Valid @RequestBody Cliente Cliente){
		Optional<Cliente> cliente_returned = ClienteService.login(Cliente);
		return new ResponseEntity<Cliente>(cliente_returned.get(), HttpStatus.OK);		
	}
	
	@ApiOperation("Actualiza una Cliente")
	@PutMapping
	public ResponseEntity<Cliente> actualizar(@Valid @RequestBody Cliente Cliente) {		
		ClienteService.modificar(Cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la Cliente correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable String id) {
		Optional<Cliente> Cliente = ClienteService.listId(id);
		if (!Cliente.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			ClienteService.eliminar(id);
		}
	}
}