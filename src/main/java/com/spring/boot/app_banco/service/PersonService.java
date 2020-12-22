package com.spring.boot.app_banco.service;

import java.util.List;

import com.spring.boot.app_banco.domain.Person;

public interface PersonService {

	Person buscarPorId(Long id);

	List<Person> buscarPorIdBanco(Long id);

	List<Person> buscarPorApellido(String apellido);

}
