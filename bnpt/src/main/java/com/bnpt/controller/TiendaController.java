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
import com.bnpt.model.entities.Tienda;
import com.bnpt.service.TiendaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Tiendas")
public class TiendaController {
	@Autowired
	private TiendaService TiendaService;
	
	@ApiOperation("Retorna una lista de Tiendas")
	@GetMapping
	public ResponseEntity<List<Tienda>> listar(){
		List<Tienda> Tiendas = new ArrayList<>();
		Tiendas = TiendaService.listar();
		return new ResponseEntity<List<Tienda>>(Tiendas, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la Tienda correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tienda> listarId(@PathVariable("id") Integer id) {
		Optional<Tienda> Tienda = TiendaService.listId(id);
		if (!Tienda.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Tienda>(Tienda.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una Tienda")
	@PostMapping
	public ResponseEntity<Tienda> registrar(@Valid @RequestBody Tienda Tienda){
		Tienda TiendaNew = new Tienda();
		TiendaNew = TiendaService.registrar(Tienda);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(TiendaNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una Tienda")
	@PutMapping
	public ResponseEntity<Tienda> actualizar(@Valid @RequestBody Tienda Tienda) {		
		TiendaService.modificar(Tienda);
		return new ResponseEntity<Tienda>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la Tienda correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Tienda> Tienda = TiendaService.listId(id);
		if (!Tienda.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			TiendaService.eliminar(id);
		}
	}
}