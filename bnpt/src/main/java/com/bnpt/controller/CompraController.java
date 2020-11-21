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
import com.bnpt.model.entities.Compra;
import com.bnpt.service.CompraService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Compras")
public class CompraController {
	@Autowired
	private CompraService CompraService;
	
	@ApiOperation("Retorna una lista de Compras")
	@GetMapping
	public ResponseEntity<List<Compra>> listar(){
		List<Compra> Compras = new ArrayList<>();
		Compras = CompraService.listar();
		return new ResponseEntity<List<Compra>>(Compras, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la Compra correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Compra> listarId(@PathVariable("id") Integer id) {
		Optional<Compra> Compra = CompraService.listId(id);
		if (!Compra.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Compra>(Compra.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una Compra")
	@PostMapping
	public ResponseEntity<Compra> registrar(@Valid @RequestBody Compra Compra){
		Compra CompraNew = new Compra();
		CompraNew = CompraService.registrar(Compra);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CompraNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una Compra")
	@PutMapping
	public ResponseEntity<Compra> actualizar(@Valid @RequestBody Compra Compra) {		
		CompraService.modificar(Compra);
		return new ResponseEntity<Compra>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la Compra correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Compra> Compra = CompraService.listId(id);
		if (!Compra.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			CompraService.eliminar(id);
		}
	}
}