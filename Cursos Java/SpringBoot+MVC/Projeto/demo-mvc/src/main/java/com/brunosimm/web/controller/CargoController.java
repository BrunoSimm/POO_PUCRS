package com.brunosimm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/cargo/lista";
	}
	
	@GetMapping("/")
	public String redirectListarBarra() {
		return "redirect:/cargos/listar";
	}
	
	@GetMapping("")
	public String redirectToListar() {
		return "redirect:/cargos/listar";
	}
	
	
}
