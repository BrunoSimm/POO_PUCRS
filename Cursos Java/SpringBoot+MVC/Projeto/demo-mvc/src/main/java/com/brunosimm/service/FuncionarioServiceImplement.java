package com.brunosimm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brunosimm.domain.Funcionario;
import com.brunosimm.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioServiceImplement implements FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	@Transactional(readOnly = false)
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		funcionarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return funcionarioRepository.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return funcionarioRepository.findAll();
	}

}
