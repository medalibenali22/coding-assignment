package com.manager.models;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.manager.enums.TransactionType;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue
	private Long id;
	private Double amount;
	private LocalDate transactionDate;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	public Transaction() {

	}
	
	public Transaction(Double amount, LocalDate transactionDate, TransactionType transactionType) {
		
		
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionType != other.transactionType)
			return false;
		return true;
	}
	
	
	

}
