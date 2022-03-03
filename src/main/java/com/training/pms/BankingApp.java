package com.training.pms;

import java.io.IOException;
import java.util.Scanner;

import com.training.pms.dao.CustomerDAO;
import com.training.pms.dao.CustomerDAOImpl;
import com.training.pms.dao.LoginDAO;
import com.training.pms.dao.LoginDAOImpl;
import com.training.pms.model.Customer;
import com.training.pms.model.Login;

public class BankingApp {
	Scanner sc = new Scanner(System.in);
	Login login = new Login();
	LoginDAO loginDAO = new LoginDAOImpl();
	Customer customer = new Customer();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	
	public void startBankingApp() throws IOException {
		// declaring local variables for input
		String username = null;
		String password = null;
		int accountNumber = 1; // need to pull account number when user logs in
		boolean isEmployee = false;
		int balance = 0;
		int amount = 0;
		int choice = 0;
		boolean loggedIn = true;
		
		while(true) {
			System.out.println("Welcome to Nagel's Bank\n");
			System.out.println("Please enter an option:");
			
			System.out.println("1. Add User");
			System.out.println("2. Login");
			System.out.println("9. EXIT");
			choice = sc.nextInt();
			
//			what I want to do is create an account, then afterwards a copy is put into 
//			either customers or employees with loginID becoming the accountNumber
			
			switch(choice) { 
				case 1: // creating user
					System.out.println("Creating an account\n");
					System.out.println("Please enter your desired username:");
					username = sc.next();
					System.out.println("Please enter your desired password:");
					password = sc.next();
					login = new Login(username, password, false);
					boolean createAccount = loginDAO.register(login);
					if(!createAccount) {
						System.out.println(
								"Could not create account, please try again");
						continue;
					}
					System.out.println("Your account has been created! Feel free to log in");
					break;
				case 2: // logging in, main menu will be here
					System.out.println("Logging in\n");		
					System.out.println("Please enter your username:");
					username = sc.next();
					System.out.println("Please enter your password:");
					password = sc.next();
					boolean loginAttempt = loginDAO.validate(username, password);
					if(!loginAttempt) { // if failed, will kick back to first menu
						System.out.println(
								"Could not log in, please try again");
					} else {
						System.out.println("Welcome, " + username + "!\n");
					}
					
					// return whether login is for customer or employee
					
					while(loggedIn && !isEmployee) { // Customer main menu
						System.out.println("---------------------");
						System.out.println("CUSTOMER MENU");
						System.out.println("1. See balance");
						System.out.println("2. Make a withdraw/deposit");
						System.out.println("3. Transfer $$ to account");
						System.out.println("4. Pending incoming transfers");
						System.out.println("9. LOG OUT");
						
						System.out.println("Please enter your choice:");
						choice = sc.nextInt();
						System.out.println("---------------------");
						
						switch(choice) {
						case 1: // balance
							System.out.println("Pulling up your balance:\n");
							balance = customerDAO.viewBalance(accountNumber);
							System.out.println("Your current balance is $" + balance);
							break;
						case 2: // withdraw or deposit
							System.out.println("Choose whether it is a deposit or a withdraw");
							System.out.println("1 for Deposit\n2 for Withdraw");
							amount = 0;
							choice = sc.nextInt();
							
							switch(choice) {
							case 1: // deposit
								System.out.println("Making a deposit:\n");
								System.out.println("Please enter the amount to deposit");
								amount = sc.nextInt();
								balance = customerDAO.depositAmount(accountNumber, amount);
								System.out.println("You have deposited $" + amount 
										+ "\nYour new balance is $" + balance);
								break;
							case 2: // withdraw
								System.out.println("Making a withdraw:\n");
								System.out.println("Please enter the amount to withdraw");
								amount = sc.nextInt();
								balance = customerDAO.withdrawAmount(accountNumber, amount);
								System.out.println("You have withdrawn $" + amount 
										+ "\nYour new balance is $" + balance);
								break;
							default:
								System.out.println("Invalid option, going back to main menu");						
							}
							break;
						case 3: // transfer to account
							System.out.println("Transferring to account:\n");
							System.out.println("Please enter accountNumber to transfer to");
							int accountReceiver = sc.nextInt();
							System.out.println("Enter the amount to transfer");
							amount = sc.nextInt();
							boolean transfer = customerDAO.transferAmount(accountNumber, amount, accountReceiver);
							if (transfer) {
								System.out.println(
										"Your transfer has been successfully posted. Awaiting an employee to approve or reject");		
							} else {
								System.out.println("There was an error with your transfer attempt");
							}
							break;
						case 4: // transfer from account
							System.out.println("Checking if there are any transfers incoming:\n");
							if(!customerDAO.checkTransfers(accountNumber)) {
								System.out.println("No incoming transfers to you");
							} else {
								
							}
							break;
						case 9: // exit
							System.out.println("Logging out, thank you for using Nagel's Bank");
							loggedIn = false;
							break;
						default:
							System.out.println("Invalid option, please enter a valid option");
						}
					}
					
					while(loggedIn && isEmployee) { // Employee main menu
						System.out.println("---------------------");
						System.out.println("EMPLOYEE MENU");
						System.out.println("1. Approve or reject account");
						System.out.println("2. View customer's account");
						System.out.println("3. View all transactions");
						System.out.println("9. LOG OUT");
						
						System.out.println("Please enter your choice:");
						choice = sc.nextInt();
						System.out.println("---------------------");
						
						switch (choice) {
						case 1: // approve or reject account
							break;
						case 2: // view customer's balance
							break;
						case 3: // view all transactions
							break;
						case 9: // exit
							System.out.println("Logging out, thank you for using Nagel's Bank");
							loggedIn = false;
							break;
						default:
							System.out.println("Invalid option, please enter a valid option");
						}
					}
				case 9:
					System.out.println("Closing application");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option, please enter a valid option");
			}
			
			
		}
	}
}
