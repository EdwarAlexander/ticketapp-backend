package com.eamr.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eamr.model.Estado;
import com.eamr.service.IEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private IEstadoService service;

	@GetMapping()
	public ResponseEntity<Page<Estado>> listar(Pageable pageable) {
		Page<Estado> lista = service.listaOrdenada(pageable);
		return new ResponseEntity<Page<Estado>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Estado obj){
		Estado estado=service.registrar(obj);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Estado obj){
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
