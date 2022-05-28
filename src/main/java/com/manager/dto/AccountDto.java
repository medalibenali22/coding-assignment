package com.manager.dto;

public class AccountDto {
	
	private long costumerId;
	private Double initialCredit;
	
	
	public AccountDto() {
	
	}
	
	public AccountDto(long costumerId, Double initialCredit) {
		
		this.costumerId = costumerId;
		this.initialCredit = initialCredit;
	}

	public long getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(long costumerId) {
		this.costumerId = costumerId;
	}

	public Double getInitialCredit() {
		return initialCredit;
	}

	public void setInitialCredit(Double initialCredit) {
		this.initialCredit = initialCredit;
	}
	
	
	
	

}
