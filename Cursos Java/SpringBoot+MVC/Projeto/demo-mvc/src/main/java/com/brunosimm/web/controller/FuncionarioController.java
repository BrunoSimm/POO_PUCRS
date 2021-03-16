package com.brunosimm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@GetMapping("/listar")
	public String listar() {
		return "/funcionario/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/")
	public String redirectListarBarra() {
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("")
	public String redirectToListar() {
		return "redirect:/funcionarios/listar";
	}
	
}
