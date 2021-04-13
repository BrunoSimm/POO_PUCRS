package com.bsimm.pontoeletronico.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.bsimm.pontoeletronico.domain.registroponto.RegistroPonto;

@Repository
public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {
	List<Funcionario> findByFuncionario(Funcionario funcionario);
	List<LocalDate> findBydataRegistro(LocalDate date);
}
