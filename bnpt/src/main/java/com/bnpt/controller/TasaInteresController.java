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
import com.bnpt.model.entities.TasaInteres;
import com.bnpt.service.TasaInteresService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/TasaInteress")
public class TasaInteresController {
	@Autowired
	private TasaInteresService TasaInteresService;
	
	@ApiOperation("Retorna una lista de TasaInteress")
	@GetMapping
	public ResponseEntity<List<TasaInteres>> listar(){
		List<TasaInteres> TasaInteress = new ArrayList<>();
		TasaInteress = TasaInteresService.listar();
		return new ResponseEntity<List<TasaInteres>>(TasaInteress, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la TasaInteres correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TasaInteres> listarId(@PathVariable("id") Integer id) {
		Optional<TasaInteres> TasaInteres = TasaInteresService.listId(id);
		if (!TasaInteres.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<TasaInteres>(TasaInteres.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una TasaInteres")
	@PostMapping
	public ResponseEntity<TasaInteres> registrar(@Valid @RequestBody TasaInteres TasaInteres){
		TasaInteres TasaInteresNew = new TasaInteres();
		TasaInteresNew = TasaInteresService.registrar(TasaInteres);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(TasaInteresNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una TasaInteres")
	@PutMapping
	public ResponseEntity<TasaInteres> actualizar(@Valid @RequestBody TasaInteres TasaInteres) {		
		TasaInteresService.modificar(TasaInteres);
		return new ResponseEntity<TasaInteres>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la TasaInteres correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<TasaInteres> TasaInteres = TasaInteresService.listId(id);
		if (!TasaInteres.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			TasaInteresService.eliminar(id);
		}
	}
}