package com.brunosimm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosimm.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
