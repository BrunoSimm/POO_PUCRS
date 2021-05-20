package com.bsimm.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsimm.algalog.domain.exception.NegocioException;
import com.bsimm.algalog.domain.model.Cliente;
import com.bsimm.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor //Injeta as dependencias pelo construtor.
@Service //Service serve para definir e aplicar regras de negócio
public class CatalogoClienteService {
	
	//Injeta as dependencias pelo construtor.
	private ClienteRepository clienteRepository;
	
	@Transactional //Declara que esse método será uma transação.
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este email");
		}
		
		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
