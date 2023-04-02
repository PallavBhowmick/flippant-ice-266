package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
	
	private String username;
	private String email;
	private double unit;
	private double price=10;
	private double total;
	private LocalDate dt;

    public Transaction() {
		
	}
    
    public Transaction(String username,String email,double unit,double price,double total,LocalDate dt) {
		
    	super();
    	this.username=username;
    	this.email=email;
    	this.unit=unit;
    	this.price=10;
    	this.total=total;
    	this.dt=dt;
    	   	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	@Override
	public String toString() {
		return "Transaction [username=" + username + ", email=" + email + ", unit=" + unit + ", price=" + price
				+ ", total=" + total + ", dt=" + dt + "]";
	}
    
    
    
}
