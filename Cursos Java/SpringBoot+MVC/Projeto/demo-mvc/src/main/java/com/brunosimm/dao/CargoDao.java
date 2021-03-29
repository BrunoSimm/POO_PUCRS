package com.brunosimm.dao;

import java.util.List;

import com.brunosimm.domain.Cargo;
import com.brunosimm.domain.Departamento;

public interface CargoDao {

	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();
	
}
