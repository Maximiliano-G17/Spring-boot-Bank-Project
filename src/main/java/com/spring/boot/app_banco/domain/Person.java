package com.spring.boot.app_banco.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = -8459134031758293609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@Pattern(regexp = "[a-zA-Z]{2,20}", message="Error, el nombre solo puede contener letras")
	private String name;
	@Pattern(regexp = "[a-zA-Z]{2,20}")
	private String surname;
	@NotNull
	@Min(7)
	private int dni;	
	@Pattern(regexp = "[a-zA-Z]{2,20}")
	private String address;	
	@NotNull
	@Min(5)
	private double balance;	
	@ManyToOne
	@JoinColumn(name = "id_bank")
	private Bank bank;	
		
	public Person() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", address=" + address
				+ ", balance=" + balance + ", bank=" + bank + "]";
	}	
}