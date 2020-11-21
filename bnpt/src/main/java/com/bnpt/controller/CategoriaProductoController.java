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
import com.bnpt.model.entities.CategoriaProducto;
import com.bnpt.service.CategoriaProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/CategoriaProductos")
public class CategoriaProductoController {
	@Autowired
	private CategoriaProductoService CategoriaProductoService;
	
	@ApiOperation("Retorna una lista de CategoriaProductos")
	@GetMapping
	public ResponseEntity<List<CategoriaProducto>> listar(){
		List<CategoriaProducto> CategoriaProductos = new ArrayList<>();
		CategoriaProductos = CategoriaProductoService.listar();
		return new ResponseEntity<List<CategoriaProducto>>(CategoriaProductos, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la CategoriaProducto correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaProducto> listarId(@PathVariable("id") Integer id) {
		Optional<CategoriaProducto> CategoriaProducto = CategoriaProductoService.listId(id);
		if (!CategoriaProducto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<CategoriaProducto>(CategoriaProducto.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una CategoriaProducto")
	@PostMapping
	public ResponseEntity<CategoriaProducto> registrar(@Valid @RequestBody CategoriaProducto CategoriaProducto){
		CategoriaProducto CategoriaProductoNew = new CategoriaProducto();
		CategoriaProductoNew = CategoriaProductoService.registrar(CategoriaProducto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CategoriaProductoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una CategoriaProducto")
	@PutMapping
	public ResponseEntity<CategoriaProducto> actualizar(@Valid @RequestBody CategoriaProducto CategoriaProducto) {		
		CategoriaProductoService.modificar(CategoriaProducto);
		return new ResponseEntity<CategoriaProducto>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la CategoriaProducto correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<CategoriaProducto> CategoriaProducto = CategoriaProductoService.listId(id);
		if (!CategoriaProducto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			CategoriaProductoService.eliminar(id);
		}
	}
}