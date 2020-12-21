package com.spring.boot.app_banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.app_banco.domain.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{

	Bank findByName(String name);
}
