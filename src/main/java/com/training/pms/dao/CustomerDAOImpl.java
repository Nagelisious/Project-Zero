package com.training.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.training.pms.model.Customer;
import com.training.pms.utility.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {
	
	Connection connection = DBConnection.getConnection();
	
	public boolean openAccount(Customer customer) {
		System.out.println("Creating an account:");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into customers values(default,?,?,default)");
			statement.setString(1, customer.getCustomerName());
			statement.setString(2, customer.getCustomerPassword());
			
			rows = statement.executeUpdate();
			System.out.println(rows + " inserted successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(rows == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int viewBalance(int accountNumber) {
		System.out.println("...Printing the balance...");
		PreparedStatement statement = null;
		int balance = 0;
		
		try {
			statement = connection.prepareStatement("select balance from customers where accountNumber = ?");
			statement.setInt(1, accountNumber);
			
			ResultSet res = statement.executeQuery();
			res.next();
			balance = res.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}

	public int withdrawAmount(int accountNumber, int amount) {
		System.out.println("Making a withdraw of $" + amount + "...");
		PreparedStatement statement = null;
		int balance = 0;
		
		try {
			statement = connection.prepareStatement( // making withdraw
					"update customers set balance = balance - ? where accountNumber = ?");
			statement.setInt(1,	amount);
			statement.setInt(2,	accountNumber);
			statement.execute();
			
			statement = connection.prepareStatement( // getting balance
					"select balance from customers where accountNumber = ?");
			statement.setInt(1, accountNumber);
			ResultSet res = statement.executeQuery();
			res.next();
			balance = res.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return balance;
	}

	public int depositAmount(int accountNumber, int amount) {
		System.out.println("Making a deposit of $" + amount + "...");
		PreparedStatement statement = null;
		int balance = 0;
		
		try {
			statement = connection.prepareStatement( // making withdraw
					"update customers set balance = balance + ? where accountNumber = ?");
			statement.setInt(1,	amount);
			statement.setInt(2,	accountNumber);
			statement.execute();
			
			statement = connection.prepareStatement( // getting balance
					"select balance from customers where accountNumber = ?");
			statement.setInt(1, accountNumber);
			ResultSet res = statement.executeQuery();
			res.next();
			balance = res.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return balance;
	}

	public boolean transferAmount(int accountSender, int amount, int accountReceiver) {
		System.out.println("Making a transfer of $" + amount + " to accountNumber " + accountReceiver + "...");
		PreparedStatement statement = null;
		int rows = 0;
		
		try {
			statement = connection.prepareStatement("insert into transfers values (default, ?, ?, ?)");
			statement.setInt(1,	accountSender);
			statement.setInt(2,	amount);
			statement.setInt(3,	accountReceiver);
			rows = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rows == 0) {
			return false;
		} else {
			return true;
		}
		
	}

	public boolean checkTransfers(int accountNumber) { // checks if there are any transfers to accountReceiver in transfers table
		System.out.println("Looking if there are any incoming transfers...");
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement("select transferID, accountSender, amount from transfers where accountReceiver = ?");
//			ResultSet res = statement.executeQuery(
//					"select transferID, accountSender, amount from transfers where accountNumber = ?");
			statement.setInt(1, accountNumber);
			ResultSet res = statement.executeQuery();
			
			if(!res.next()) { // if no transfers, return false and print that there are none
				return false;
			} else { // prints out line by line the ID of transfer, account it's from, and amount
				while(res.next()) { // continue to see whole list of transfers
					System.out.print("Transfer ID: " + res.getInt(1) + " --- ");
					System.out.print("Account Sender: " + res.getInt(2) + " --- ");
					System.out.println("Transfer Amount: " + res.getInt(3) + "\n");
				}
			}

		} catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean acceptTransfer(int accountNumber) {
		return false;
		// TODO Auto-generated method stub
		
	}



}
