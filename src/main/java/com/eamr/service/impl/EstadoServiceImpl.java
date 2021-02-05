package com.eamr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eamr.model.Estado;
import com.eamr.repo.IEstadoRepo;
import com.eamr.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{

	@Autowired
	private IEstadoRepo repo;
	
	@Override
	public Estado registrar(Estado obj) {
		return repo.save(obj);
	}

	@Override
	public Estado modificar(Estado obj) {
		return repo.save(obj);
	}

	@Override
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado ListarPorId(Integer id) {
		Optional<Estado> estado= repo.findById(id);
		return estado.isPresent() ? estado.get() : new Estado();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Estado> listaOrdenada(Pageable pageable) {
		return repo.listaOrdenada(pageable);
	}

}
