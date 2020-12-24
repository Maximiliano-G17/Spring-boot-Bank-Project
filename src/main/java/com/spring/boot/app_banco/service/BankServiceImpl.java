package com.spring.boot.app_banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app_banco.domain.Bank;
import com.spring.boot.app_banco.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService{
	
	private BankRepository bankRepo;

	@Autowired
	public BankServiceImpl(BankRepository bankRepo) {
		this.bankRepo = bankRepo;
	}

	@Override
	public Bank buscarPorId(Long id) {
		return bankRepo.findById(id).orElse(null);
	}

	@Override
	public List<Bank> buscarTodos() {
		return bankRepo.findAll();
	}

	@Override
	public Bank buscarPorNombre(String nombre) {
		return bankRepo.findByName(nombre);
	}

	
}