package com.bsimm.pontoeletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByNomeContaining(String nome);
	Funcionario findByEmail(String email);
	Funcionario findByEmailContaining(String email);
}
