package com.eamr.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eamr.model.Estado;

public interface IEstadoRepo extends JpaRepository<Estado,Integer>{

	@Query("from Estado e order by e.id desc")
	Page<Estado> listaOrdenada(Pageable pageable);
}
