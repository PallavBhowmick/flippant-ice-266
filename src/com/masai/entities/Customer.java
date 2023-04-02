package com.masai.entities;
import java.io.Serializable;

public class Customer extends User implements Serializable{
	private double balance;
	public Customer (double balance,String firstname,String lastname,String username, String password, String address,String mobile, String email) {
		super(firstname,lastname,username,password,address,mobile,email);
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [balance=" + balance + ", getBalance()=" + getBalance() + ", getFirstname()=" + getFirstname()
				+ ", getLastname()=" + getLastname() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getAddress()=" + getAddress() + ", getMobile()=" + getMobile() + ", getEmail()="
				+ getEmail() + "]";
	}

	

	
	
}
