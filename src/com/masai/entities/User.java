package com.masai.entities;
import java.io.Serializable;

public class User implements Serializable  {
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String address;
	private String mobile;
	private String email;

	public User() {
		super();
	}
	

	public User(String firstname,String lastname,String username, String password, String address,String mobile, String email) {
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobile=mobile;
		this.email = email;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", address=" + address + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
	
	

}
