package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.utility.Admin;
import com.masai.entities.Transaction;
import com.masai.exceptions.InputInvalidException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.TransactionException;

public interface AdminService extends Admin {
	
	
	public boolean login(String userame,String password) throws InvalidDetailsException;	
	
	public List<Transaction> viewCustomerTransactions(String username, List<Transaction> transactions)throws TransactionException;
	
	public List<Transaction> viewAllTransactions(List<Transaction> transactions) throws TransactionException;
	
	public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws InputInvalidException;
	
	List<Transaction> viewCustomerAllTrasaction(String username, List<Transaction> transactions) throws TransactionException;
	
	//public void deleteProduct(int id, Map<Integer, Product> products) throws ProductException;


	List<Transaction> addProduct(String username, String email, int unit, List<Transaction> transactions,
			Map<Integer, Product> products) throws TransactionException;


}
