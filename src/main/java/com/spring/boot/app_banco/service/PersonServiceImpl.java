package com.spring.boot.app_banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app_banco.domain.Person;
import com.spring.boot.app_banco.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person buscarPorId(Long id) {
		return personRepo.findById(id).orElse(null);
	}

	@Override
	public List<Person> buscarPorIdBanco(Long id) {
		return personRepo.findByBankId(id);
	}

	@Override
	public List<Person> buscarPorApellido(String apellido) {
		return personRepo.findBySurname(apellido);
	}

	
}
