package com.training.pms.model;

import java.util.Objects;

public class Customer {
	private int accountNumber;
	private String customerName;
	private String customerPassword;
	private int balance;
	
	public Customer() {
		super();
	}

	public Customer(int accountNumber, String customerName, String customerPassword, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.balance = balance;
	}
	
	public Customer(int accountNumber, int balance) { // for testing
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, balance, customerName, customerPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return accountNumber == other.accountNumber && balance == other.balance
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerPassword, other.customerPassword);
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", balance=" + balance + "]";
	}

}
