package com.bsimm.pontoeletronico.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.bsimm.pontoeletronico.repository.FuncionarioRepository;
import com.bsimm.pontoeletronico.service.FuncionarioService;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> findAll(){
		return funcionarioService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario cadastrarFuncionario(@Valid @RequestBody Funcionario funcionario){
		return funcionarioService.cadastrar(funcionario);
	}
	
	@PutMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		if (!funcionarioService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(id);
		
		//Por contar o Id no objeto, o funcionário será apenas atualizado.
		return ResponseEntity.ok(funcionarioService.atualizar(funcionario););
	}
	
	@DeleteMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> removerFuncionario(@PathVariable Long id) {
		if (!funcionarioService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		funcionarioService.delete(id);
		return ResponseEntity.ok("Funcionário de id "+ id+" removido com sucesso!");
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	public ResponseEntity<Funcionario> getByCPF(@PathVariable String cpf) {
		Optional<Funcionario> funcionario = funcionarioService.findByCpf(cpf);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioService.findById(id);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}
}
