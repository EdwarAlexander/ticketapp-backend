package com.eamr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eamr.model.Area;

public interface IAreaService extends CRUD<Area, Integer> {

	Page<Area> listaOrdenada(Pageable pageable);
}
