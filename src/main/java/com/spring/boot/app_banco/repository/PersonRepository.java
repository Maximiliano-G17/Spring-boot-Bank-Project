package com.spring.boot.app_banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.app_banco.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	List<Person> findByBankId(Long id);

	List<Person> findBySurname(String surname);
}