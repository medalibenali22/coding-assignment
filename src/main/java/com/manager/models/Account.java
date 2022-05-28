package com.manager.models;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // this was commented
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	private double balance;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@ElementCollection(targetClass=Transaction.class)
	private List<Transaction> transaction;
	
	
	
	
	public Account(Long id, double balance, List<Transaction> transaction) {
		
		this.id = id;
		this.balance = balance;
		this.transaction = transaction;
	}

	public Account() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		
		this.balance = balance;
	}
	
    @JoinTable(name = "account_transaction",
    joinColumns = {@JoinColumn (name="account_id")},
               inverseJoinColumns = {@JoinColumn (name="transaction_id")} )
	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	
	

}
