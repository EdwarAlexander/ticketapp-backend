package com.eamr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eamr.model.Area;
import com.eamr.repo.IAreaRepo;
import com.eamr.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService{

	@Autowired
	private IAreaRepo repo;
	
	@Override
	public Area registrar(Area obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Area modificar(Area obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Area> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Area ListarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Area> area=repo.findById(id);
		return area.isPresent() ? area.get() : new Area();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Area> listaOrdenada(Pageable pageable) {
		// TODO Auto-generated method stub
		return repo.listaOrdenada(pageable);
	}

}
