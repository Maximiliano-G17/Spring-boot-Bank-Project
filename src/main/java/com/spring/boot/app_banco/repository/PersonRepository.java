package com.spring.boot.app_banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.app_banco.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
