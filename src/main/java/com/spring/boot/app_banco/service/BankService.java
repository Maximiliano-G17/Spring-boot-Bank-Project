package com.spring.boot.app_banco.service;

import java.util.List;

import com.spring.boot.app_banco.domain.Bank;

public interface BankService {

	Bank buscarPorId(Long id);

	List<Bank> buscarTodos();

	Bank buscarPorNombre(String nombre);

}
