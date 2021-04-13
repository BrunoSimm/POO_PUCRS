package com.brunosimm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.brunosimm.domain.Cargo;
import com.brunosimm.domain.Departamento;
import com.brunosimm.repository.CargoRepository;
import com.brunosimm.repository.DepartamentoRepository;
import com.brunosimm.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	CargoRepository cargoRepository;
	
	@Autowired
	CargoService cargoService;
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoRepository.findAll());
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
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		if (cargo.getDepartamento() == null) {
			attr.addFlashAttribute("fail","Selecione um departamento!");
			return "redirect:/cargos/cadastrar";
		} else {
			cargoRepository.save(cargo);
			attr.addFlashAttribute("success","Cargo inserido com sucesso.");
		}
			return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute("success","Registro atualizado com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (cargoService.cargoTemFuncionarios(id) == false) {
			cargoService.excluir(id);
			attr.addFlashAttribute("success","Cargo excluido com sucesso.");
		} else {
			attr.addFlashAttribute("fail","Cargo não excluido. Possui funcionário(s) vinculado(s).");
		}
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos(){
		return departamentoRepository.findAll();
	}
	
}
