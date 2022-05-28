package com.manager.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@Column(name = "customerId", nullable = false)
	private Long customerId;
	private String name;
	private String surname;

	@OneToOne(cascade = {CascadeType.ALL})
	private Account account;

	public Customer() {

	}

	public Customer(Long customerId, String name, String surname) {

		this.customerId = customerId;
		this.name = name;
		this.surname = surname;

	}

	public Customer(Long customerId, String name, String surname, Account account) {

		this.customerId = customerId;
		this.name = name;
		this.surname = surname;
		this.account = account;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
