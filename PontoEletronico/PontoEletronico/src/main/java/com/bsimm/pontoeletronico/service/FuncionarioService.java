package com.bsimm.pontoeletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsimm.pontoeletronico.controller.exceptions.BusinessRuleException;
import com.bsimm.pontoeletronico.controller.exceptions.ConstraintException;
import com.bsimm.pontoeletronico.controller.exceptions.DataIntegrityException;
import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.bsimm.pontoeletronico.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionario cadastrar(Funcionario funcionario) {
		try {
			if(funcionarioRepository.existsByCpf(funcionario.getCpf()) == true ) {
				throw new DataIntegrityException("Falha ao cadastrar, funcionário de CPF "+funcionario.getCpf() +" já cadastrado.");
			} else return funcionarioRepository.save(funcionario);
		} catch (ConstraintException e) {
			throw new ConstraintException("Campo(s) obrigatório(s) do Funcionário não foi(foram) preenchido(s).");
		}
	}
	
	
	// TODO -> Ainda não está funcional a atualização de dados, precisa implementar.
	// O ideal é passar apenas o Id e os dados que quer atualizar, não sendo necessário passar todos os dados.
	public Funcionario atualizar(Funcionario funcionario) {
		
		//Filtrar quais dados vieram e atualizar estes.
		
		
		
		
		return funcionarioRepository. save(funcionario);
	}
	
	public List<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> findById(Long id) {
		return funcionarioRepository.findById(id);
	}
	
	
	public Optional<Funcionario> findByCpf(String cpf) {
		return funcionarioRepository.findByCpf(cpf);
	}

	public boolean delete(Long id) {
		funcionarioRepository.deleteById(id);
		return true;
	}

	public boolean existsById(Long id) {
		return funcionarioRepository.existsById(id);
	}
	
	//TODO - Métodos adicionar,update, delete.
	//TODO - Validações de inserção,update e delete.
}
