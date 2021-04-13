package com.bsimm.pontoeletronico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bsimm.pontoeletronico.controller.exceptions.DataIntegrityException;
import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.bsimm.pontoeletronico.repository.FuncionarioRepository;

@Service
public class CadastroFuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionario cadastrar(Funcionario funcionario) {
		try {
			return funcionarioRepository.save(funcionario);
		} catch (DataIntegrityViolationException e) {
			if(funcionarioRepository.findByCPF(funcionario.getCpf()) == true) {
				
			}
			throw new DataIntegrityException("Campo(s) obrigatório(s) do Funcionário não foi(foram) preenchido(s).");
		}
		
	}
	//TODO - Métodos adicionar,update, delete.
	//TODO - Validações de inserção,update e delete.
}
