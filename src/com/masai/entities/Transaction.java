package com.masai.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
	
	private String username;
	private String email;
	private double unit;
	private String status;
	private LocalDate dt;

    public Transaction() {
		
	}
    
    public Transaction(String username,String email,double unit, String status,LocalDate dt) {
		
    	super();
    	this.username=username;
    	this.email=email;
    	this.unit=unit;
    	this.status=status;
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
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	@Override
	public String toString() {
		return "Transaction [username=" + username + ", email=" + email + ", unit=" + unit + ", status=" + status
				+ ", dt=" + dt + "]";
	}

	

	






    
    
    
}
