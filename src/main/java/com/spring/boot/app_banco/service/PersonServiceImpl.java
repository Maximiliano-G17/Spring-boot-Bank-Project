package com.spring.boot.app_banco.service;

import org.springframework.stereotype.Service;

import com.spring.boot.app_banco.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	private PersonRepository personRepo;

	public PersonServiceImpl(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	
}
