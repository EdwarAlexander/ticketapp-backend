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

import com.eamr.model.Area;
import com.eamr.service.IAreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {

	@Autowired
	private IAreaService service;
	
	@GetMapping
	public ResponseEntity<Page<Area>> listar(Pageable pageable){
		Page<Area> area=service.listaOrdenada(pageable);
		return new ResponseEntity<Page<Area>>(area,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Area obj){
		Area area=service.registrar(obj);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(area.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Area obj){
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Area> buscar(@PathVariable Integer id) {
		Area area=service.ListarPorId(id);
		return new ResponseEntity<Area>(area,HttpStatus.OK);
	}
}
