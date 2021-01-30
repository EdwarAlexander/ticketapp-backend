package com.eamr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eamr.model.Nivel;

public interface INivelService extends CRUD<Nivel,Integer>{

	Page<Nivel> listaOrdenada(Pageable pageable);
}
