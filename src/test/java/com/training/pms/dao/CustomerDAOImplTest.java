package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.training.pms.dao.CustomerDAOImpl;
import com.training.pms.dao.CustomerDAO;
import com.training.pms.model.Customer;

class CustomerDAOImplTest {
	
	Customer c;
	CustomerDAO cDAO;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Setup class called");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Teardown class called");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setup called");
		c = new Customer(1, 10000);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Teardown called");
		c = null;
	}

	@Test
	void testWithdrawAmount() {
		int actual = cDAO.withdrawAmount(1, 1);
		assertEquals(9999, actual);
	}

	@Test
	void testDepositAmount() {
		int actual = cDAO.depositAmount(1, 1);
		assertEquals(10001, actual);
	}

}
