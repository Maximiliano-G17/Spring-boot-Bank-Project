package com.spring.boot.app_banco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boot.app_banco.domain.Bank;
import com.spring.boot.app_banco.domain.Person;
import com.spring.boot.app_banco.service.BankService;
import com.spring.boot.app_banco.service.PersonService;

@Controller
@RequestMapping("personas")
public class PersonController {
		
	private PersonService personService;
	private BankService bankService;
	
	@Autowired
	public PersonController(PersonService personService,BankService bankService) {
		this.personService = personService;
		this.bankService = bankService;
	}

	@GetMapping("/")
	public String listarPersonas(Model model) {
		List<Person> listaDePersonas = personService.buscarTodos();
		model.addAttribute("listaDePersonas", listaDePersonas);
		return "views/listarPersonas"; 
	}
	
	@GetMapping("/registrar")
	public String preRegister(Model model) {
		List<Bank> listaDeBancos = bankService.buscarTodos();
		model.addAttribute("listaDeBancos", listaDeBancos);
		model.addAttribute("person", new Person());
		return "/views/register";
	}
	
	@PostMapping("/postRegistrar")
	public String postRegister(@Valid @ModelAttribute Person person,BindingResult result,Model model) {
		System.out.println(person);
		if (result.hasErrors()) {
			List<Bank> listaDeBancos = bankService.buscarTodos();
			model.addAttribute("listaDeBancos", listaDeBancos);
			model.addAttribute("person", new Person());
			return "/views/register";
		}
		personService.guardarPersona(person);
		return "redirect:/personas/";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long idPerson, Model model) {
		Person personToUpdate = personService.buscarPorId(idPerson);
		if (personToUpdate == null) {
			return "redirect:/personas/";
		}
		List<Bank> listaDeBancos = bankService.buscarTodos();
		model.addAttribute("listaDeBancos", listaDeBancos);
		model.addAttribute("person", personToUpdate);
		return "views/register";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long idPerson) {
		Person personaAEliminar = personService.buscarPorId(idPerson);
		if (personaAEliminar == null) {
			return "redirect:/personas/";
		}
		personService.EliminarPersona(idPerson);
		return "redirect:/personas/";
	}
}