package com.bnpt.controller;

import java.net.URI;
import java.time.LocalDateTime;
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
import com.bnpt.model.entities.Credito;
import com.bnpt.service.CreditoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Creditos")
public class CreditoController {
	@Autowired
	private CreditoService CreditoService;
	
	@ApiOperation("Retorna una lista de Creditos")
	@GetMapping
	public ResponseEntity<List<Credito>> listar(){
		List<Credito> Creditos = new ArrayList<>();
		Creditos = CreditoService.listar();
		return new ResponseEntity<List<Credito>>(Creditos, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna la Credito correspondiente al id dado")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Credito> listarId(@PathVariable("id") Integer id) {
		Optional<Credito> Credito = CreditoService.listId(id);
		if (!Credito.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		
		return new ResponseEntity<Credito>(Credito.get(), HttpStatus.OK);
	}

	@ApiOperation("Retorna la créditos asociados al cliente correspondiente al id dado")
	@GetMapping(value = "/Cliente/{id}")
	public ResponseEntity<List<Credito>> listarPorClienteId(@PathVariable("id") String id) {
		List<Credito> Creditos = CreditoService.listarPorClienteId(id);
		
		return new ResponseEntity<List<Credito>>(Creditos, HttpStatus.OK);
	}

	@ApiOperation("Retorna la créditos activos asociados al cliente correspondiente al id dado")
	@GetMapping(value = "/Cliente/{id}/Activos")
	public ResponseEntity<List<Credito>> listarActivosPorClienteId(@PathVariable("id") String id) {
		List<Credito> Creditos = CreditoService.listarActivosPorClienteId(id);
		
		return new ResponseEntity<List<Credito>>(Creditos, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna los creditos asociados en base a la fecha de vencimiento indicada")
	@GetMapping(value = "/Credito/{fecha_vencimiento}")
	public ResponseEntity<List<Credito>> creditosPorFechaVencimiento(@PathVariable("fecha_vencimiento") LocalDateTime fecha) {
		List<Credito> Creditos = CreditoService.creditosPorFechaVencimiento(fecha);
		
		return new ResponseEntity<List<Credito>>(Creditos, HttpStatus.OK);
	}

	@ApiOperation("Retorna los creditos a vencer a la fecha de hoy")
	@GetMapping(value = "/Credito/{id_tienda}/hoy")
	public ResponseEntity<List<Credito>> CreditosAVencerHoy(@PathVariable("id_tienda") Integer id_tienda) {
		List<Credito> Creditos = CreditoService.CreditosPorVencerHoy(id_tienda);
		
		return new ResponseEntity<List<Credito>>(Creditos, HttpStatus.OK);
	}

	@ApiOperation("Registra una Credito")
	@PostMapping
	public ResponseEntity<Credito> registrar(@Valid @RequestBody Credito Credito){
		Credito CreditoNew = new Credito();
		CreditoNew = CreditoService.registrar(Credito);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(CreditoNew.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@ApiOperation("Actualiza una Credito")
	@PutMapping
	public ResponseEntity<Credito> actualizar(@Valid @RequestBody Credito Credito) {		
		CreditoService.modificar(Credito);
		return new ResponseEntity<Credito>(HttpStatus.OK);
	}
	
	@ApiOperation("Elimina la Credito correspondiente al id dado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		Optional<Credito> Credito = CreditoService.listId(id);
		if (!Credito.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			CreditoService.eliminar(id);
		}
	}
}