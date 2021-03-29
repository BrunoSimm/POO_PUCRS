package com.brunosimm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brunosimm.domain.Departamento;
import com.brunosimm.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImplement implements DepartamentoService {
	
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	@Override
	@Transactional(readOnly = false)
	public void salvar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		departamentoRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return departamentoRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return departamentoRepository.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

}
