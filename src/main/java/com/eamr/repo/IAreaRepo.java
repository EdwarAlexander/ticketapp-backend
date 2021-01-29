package com.eamr.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eamr.model.Area;

public interface IAreaRepo extends JpaRepository<Area,Integer> {

	@Query("from Area a order by a.id desc")
	Page<Area> listaOrdenada(Pageable pageable);
	
}
