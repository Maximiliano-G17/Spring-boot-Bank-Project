package com.spring.boot.app_banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.app_banco.domain.Bank;
import com.spring.boot.app_banco.service.BankService;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class BankServiceTest {
	
	@Autowired
	private BankService bankService;
	
	@Test
	public void buscarPorId_conIdExistente_retornaBancoEspecifico() {
		Long id=1L;
		
		Bank bancoEncontrado = bankService.buscarPorId(id);	
		
		assertThat(bancoEncontrado).isNotNull();
		assertEquals(id, bancoEncontrado.getId());
	}
	
	@Test
	public void buscarPorId_conIdInexistente_retornaNull() {
		Long id=-99L;
		
		Bank bankNull = bankService.buscarPorId(id);	
		
		assertThat(bankNull).isNull();
	}	
	
	@Test
	public void buscarPorNombre_conNombreExistente_retornaBancoEspecifico() {
		String nombre = "Santander Rio";
		
		Bank bancoEncontrado = bankService.buscarPorNombre(nombre);	
		
		assertThat(bancoEncontrado).isNotNull();
		assertEquals(nombre, bancoEncontrado.getName());
	}
	@Test
	public void buscarPorNombre_conNombreInexistente_retornaNull() {
		String nombre = "Lalala";
		
		Bank bankNull = bankService.buscarPorNombre(nombre);	
		
		assertThat(bankNull).isNull();
	}
	
	@Test
	public void buscarTodosLosBancos_retornaListaDeBancos() {
		int size = bankService.buscarTodos().size();
		
		List<Bank> listaDeBancos = bankService.buscarTodos();
		
		assertEquals(size, listaDeBancos.size());
	}
}