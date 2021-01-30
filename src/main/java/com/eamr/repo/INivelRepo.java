package com.eamr.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eamr.model.Nivel;

public interface INivelRepo extends JpaRepository<Nivel,Integer>{

	@Query("from Nivel n order by n.id desc")
	Page<Nivel> listaOrdena(Pageable pageable);
}
