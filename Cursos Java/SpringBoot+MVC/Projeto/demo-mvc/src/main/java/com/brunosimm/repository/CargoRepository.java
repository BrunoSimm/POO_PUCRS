package com.brunosimm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunosimm.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
