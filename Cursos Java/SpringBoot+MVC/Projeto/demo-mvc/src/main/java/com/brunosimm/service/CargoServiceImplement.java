package com.brunosimm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brunosimm.domain.Cargo;
import com.brunosimm.repository.CargoRepository;

@Service
@Transactional(readOnly = false)
public class CargoServiceImplement implements CargoService {
	
	
	@Autowired
	CargoRepository cargoRepository;

	@Override
	public void salvar(Cargo cargo) {//Não recebe um id
		cargoRepository.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {//Recebe um id
		cargoRepository.save(cargo);
		
	}

	@Override
	public void excluir(Long id) {
		Cargo cargo = cargoRepository.findById(id).get();
		cargoRepository.deleteById(cargo.getId());
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return cargoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return cargoRepository.findAll();
	}

}
