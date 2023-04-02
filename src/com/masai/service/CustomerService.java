package com.masai.service;

import java.util.List;
import java.util.Map;
import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.TransactionException;
import com.masai.exceptions.InputInvalidException;
public interface CustomerService  {

	public boolean login(String userame,String password, Map<String, Customer> customers) throws InvalidDetailsException;	
	
	public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException;
	
	public boolean payMoney(double amount, String username, Map<String, Customer> customers);
	
	public double viewBalance(String username, Map<String, Customer> customers);
	
	public Customer viewCustomerDetails(String username, Map<String, Customer> customers);
		
	public List<Transaction> customerViewCustomerTransactions(String username, List<Transaction> transactions)	throws TransactionException;



	public boolean generateBill(int id, String username, Map<Integer, Product> products, Map<String, Customer> customers,
			List<Transaction> transactions) throws InvalidDetailsException, InputInvalidException, TransactionException;
	
	
	
	
}
