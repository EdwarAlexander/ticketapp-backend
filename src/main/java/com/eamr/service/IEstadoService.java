package com.eamr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eamr.model.Estado;

public interface IEstadoService extends CRUD<Estado,Integer>{

	Page<Estado> listaOrdenada(Pageable pageable);
}
