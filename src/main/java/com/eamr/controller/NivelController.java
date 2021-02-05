package com.eamr.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eamr.model.Nivel;
import com.eamr.service.INivelService;

@RestController
@RequestMapping("/niveles")
public class NivelController {

	@Autowired
	private INivelService service;

	@GetMapping
	public ResponseEntity<Page<Nivel>> listar(Pageable pageable) {
		Page<Nivel> nivel = service.listaOrdenada(pageable);
		return new ResponseEntity<Page<Nivel>>(nivel, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Nivel obj) {
		Nivel nivel = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nivel.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Nivel obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Nivel> buscar(@PathVariable Integer id) {
		Nivel nivel = service.ListarPorId(id);
		return new ResponseEntity<Nivel>(nivel, HttpStatus.OK);
	}
}
