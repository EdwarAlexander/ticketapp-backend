package com.eamr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eamr.model.Nivel;
import com.eamr.repo.INivelRepo;
import com.eamr.service.INivelService;

@Service
public class NivelServiceImpl implements INivelService{

	@Autowired
	private INivelRepo repo;

	@Override
	public Nivel registrar(Nivel obj) {
		return repo.save(obj);
	}

	@Override
	public Nivel modificar(Nivel obj) {
		return repo.save(obj);
	}

	@Override
	public Nivel ListarPorId(Integer id) {
		Optional<Nivel> nivel= repo.findById(id);
		return nivel.isPresent() ? nivel.get() : new Nivel();
	}

	@Override
	public List<Nivel> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Nivel> listaOrdenada(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.listaOrdena(pageable);
	}
}
