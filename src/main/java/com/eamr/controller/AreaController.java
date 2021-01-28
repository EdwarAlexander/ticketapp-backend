package com.eamr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eamr.model.Area;
import com.eamr.service.IAreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {

	@Autowired
	private IAreaService service;
	
	@GetMapping
	public ResponseEntity<List<Area>> listar(){
		List<Area> area=service.listar();
		return new ResponseEntity<List<Area>>(area,HttpStatus.OK);
	}
}
