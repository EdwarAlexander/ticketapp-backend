package com.eamr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eamr.model.Area;

public interface IAreaRepo extends JpaRepository<Area,Integer> {

}
