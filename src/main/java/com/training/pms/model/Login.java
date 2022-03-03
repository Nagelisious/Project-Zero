package com.training.pms.model;

import java.util.Objects;

public class Login {
	private int loginID;
	private String username;
	private String password;
	private boolean isEmployee;
	
	public Login() {
		super();
	}
	
	public Login(int loginID, String username, String password, boolean isEmployee) {
		super();
		this.loginID = loginID;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}

	public Login(String username, String password, boolean isEmployee) {
		super();
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}

	public int getLoginID() {
		return loginID;
	}


	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isEmployee, loginID, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return isEmployee == other.isEmployee && loginID == other.loginID && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Login [loginID=" + loginID + ", username=" + username + ", password=" + password + ", isEmployee="
				+ isEmployee + "]";
	}
	
}
