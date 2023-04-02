package com.masai.entities;
import java.io.Serializable;

public class Customer extends User implements Serializable{
	private double bill;
	public Customer (double bill,String firstname,String lastname,String username, String password, String address,String mobile, String email) {
		super(firstname,lastname,username,password,address,mobile,email);
		this.bill=bill;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "Customer [bill=" + bill + ", getBill()=" + getBill() + ", getFirstname()=" + getFirstname()
				+ ", getLastname()=" + getLastname() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getAddress()=" + getAddress() + ", getMobile()=" + getMobile() + ", getEmail()="
				+ getEmail() + "]";
	}
	
	
}
