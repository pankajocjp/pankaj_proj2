package org.cg.training.vo;

/**
 * Value objects for Account
 * 
 * @author njasani
 *
 */
public class Account {

	private Long accountNo;
	
	private String owner;
	
	private double balance;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long value) {
		this.accountNo = value;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String value) {
		this.owner = value;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double value) {
		this.balance = value;
	}
}
