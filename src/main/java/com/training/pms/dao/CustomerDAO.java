package com.training.pms.dao;

import java.util.List;

import com.training.pms.model.Customer;

public interface CustomerDAO {
	public boolean openAccount(Customer customer);
	public int viewBalance(int accountNumber);
	public int withdrawAmount(int accountNumber, int amount);
	public int depositAmount(int accountNumber, int amount);
	public boolean transferAmount(int accountSender, int amount, int accountReceiver);
	public boolean checkTransfers(int accountNumber);
	public boolean acceptTransfer(int accountNumber);
}
