package com.bsimm.pontoeletronico.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.bsimm.pontoeletronico.repository.FuncionarioRepository;
import com.bsimm.pontoeletronico.service.CadastroFuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	CadastroFuncionarioService cadastroFuncionarioService;
	
	@GetMapping
	private List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Funcionario> getById(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Funcionario cadastrarFuncionario(@Valid @RequestBody Funcionario funcionario){
		return cadastroFuncionarioService.cadastrar(funcionario);
	}
	
	
	
}
