package com.spring.boot.app_banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.app_banco.domain.Person;
import com.spring.boot.app_banco.service.PersonService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Test
	public void buscarTodasLasPersonas_retornaUnaListaDePersonas() {
		
		List<Person> listaDePersonas = personService.buscarTodos();
		
		assertThat(listaDePersonas).isNotNull();
		assertEquals(5,listaDePersonas.size());
	}
	
	@Test
	public void buscarPorId_conIdExistente_retornaUnaPersonaEspecifica() {
		Long id=1L;
		
		Person personBuscadaConId = personService.buscarPorId(id);
		
		assertThat(personBuscadaConId).isNotNull();
		assertEquals(id, personBuscadaConId.getId());
	}
	
	@Test
	public void buscarPorId_conIdInexistente_retornaNull() {
		Long id=-99L;
		
		Person personBuscadaConId = personService.buscarPorId(id);
		
		assertThat(personBuscadaConId).isNull();
	}
	
	@Test
	public void buscarPorIdDeBanco_conIdExistente_retornaUnBancoEspecifico() {
		Long id=1L;
		
		List<Person> personasBuscadas = personService.buscarPorIdBanco(id);
		
		assertThat(personasBuscadas).isNotNull();
		assertEquals(id, personasBuscadas.get(0).getBank().getId());
	}
	
	@Test
	public void buscarPorIdDeBanco_conIdInexistente_retornaUnBancoNull() {
		Long id=-99L;
		
		List<Person> personasBuscadas = personService.buscarPorIdBanco(id);
		
		assertThat(personasBuscadas).isEmpty();
	}
	
	@Test
	public void buscarPorApellido_conApellidoExistente_retornaUnaPersonaEspecifica() {
		String apellido = "Perez";
		
		List<Person> personasBuscadasConApellido = personService.buscarPorApellido(apellido);
		
		assertThat(personasBuscadasConApellido).isNotNull();
		assertEquals(apellido, personasBuscadasConApellido.get(0).getSurname());
	}
	
	@Test
	public void buscarPorApellido_conApellidoInexistente_retornaNull() {
		String apellido = "LALALA";
		
		List<Person> personasBuscadasConApellido = personService.buscarPorApellido(apellido);
		
		assertThat(personasBuscadasConApellido).isEmpty();
	}
	
//	@Test
//	public void guardarPersona() {
//		Person personaAGuardar = new Person();
//		personaAGuardar.setaddress("San Martin 222");
//		personaAGuardar.setbalance(46000);
//		personaAGuardar.setDni(22541256);
//		personaAGuardar.setName("Carlos");
//		personaAGuardar.setSurname("Monzon");
//		
//		Person personaGuardada = personService.guardarPersona(personaAGuardar);
//		
//		assertEquals(personaAGuardar.getName(), personaGuardada.getName());
//	}
}