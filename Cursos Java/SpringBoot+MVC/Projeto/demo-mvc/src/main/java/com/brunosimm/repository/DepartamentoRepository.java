package com.brunosimm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosimm.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
