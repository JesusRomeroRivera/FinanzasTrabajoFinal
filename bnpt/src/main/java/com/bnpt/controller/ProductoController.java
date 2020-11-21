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
import com.bnpt.model.entities.Producto;
import com.bnpt.service.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Productos")
public class ProductoController {
	@Autowired
	private ProductoService ProductoService;
	
	@ApiOperation("Retorna una lista de Productos")
	@GetMapping
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> Productos = new ArrayList<>();
		Productos = ProductoService.listar();
		return new ResponseEntity<List<Producto>>(Productos, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la Producto correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Producto> listarId(@PathVariable("id") Integer id) {
		Optional<Producto> Producto = ProductoService.listId(id);
		if (!Producto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Producto>(Producto.get(), HttpStatus.OK);
	}
	
	@ApiOperation("Registra una Producto")
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto Producto){
		Producto ProductoNew = new Producto();
		ProductoNew = ProductoService.registrar(Producto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ProductoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una Producto")
	@PutMapping
	public ResponseEntity<Producto> actualizar(@Valid @RequestBody Producto Producto) {		
		ProductoService.modificar(Producto);
		return new ResponseEntity<Producto>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la Producto correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Producto> Producto = ProductoService.listId(id);
		if (!Producto.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			ProductoService.eliminar(id);
		}
	}
}