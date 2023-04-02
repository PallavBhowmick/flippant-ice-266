package com.masai.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.InputInvalidException;
import com.masai.exceptions.TransactionException;

import com.masai.utility.IDGen;

public class AdminServiceImple implements AdminService{
	


	@Override
	public boolean login(String username,String password) throws InvalidDetailsException {

		if (username=="admin") {
			
			if(password=="admin") {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("You are not admin");
		}

	}
	
	
	@Override
	public List<Transaction> viewCustomerTransactions(String username, List<Transaction> transactions)	throws TransactionException {
		List<Transaction> myTransactions = new ArrayList<>();

		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				myTransactions.add(tr);

				flag = true;
			}
		}
		if (!flag) {
			throw new TransactionException("you hav not done any transaction yet");
		}

		return myTransactions;
	}
	
	
	@Override
	public List<Transaction> viewAllTransactions(List<Transaction> transactions) throws TransactionException {
		// TODO Auto-generated method stub
		if(transactions != null && transactions.size()>0) {
			return transactions;
		}
		else {
			throw new TransactionException("no transactions yet");
		}
		
	}
	
	@Override
	public List<Customer> viewAllCustomers(Map<String, Customer> customers) throws InputInvalidException {
		// TODO Auto-generated method stub
		List<Customer> list = null;

		if (customers != null && customers.size() > 0) {
			Collection<Customer> coll = customers.values();
			list = new ArrayList<>(coll);
		} else {
			throw new InputInvalidException("Customer list is empty");
		}

		return list;
	}
	
	
	@Override
	public List<Transaction> viewCustomerAllTrasaction(String username, List<Transaction> transactions) throws TransactionException {
		List<Transaction> myTransactions = new ArrayList<>();

		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				myTransactions.add(tr);

				flag = true;
			}
		}
		if (!flag) {
			throw new TransactionException("you hav not done any transaction yet");
		}

		return myTransactions;
	}


	@Override
	public List<Transaction> addProduct(String username, String email, int unit, List<Transaction> transactions,Map<Integer, Product> products) throws TransactionException {
		List<Transaction> myTransactions = new ArrayList<>();
		    int ddj=IDGen.generateId();
			Product ppd= new Product(ddj,unit);
			products.put(ddj, ppd);
			System.out.println("id:"+ddj);
			LocalDate ppt=LocalDate.now();
			Transaction ttr=new Transaction(username,email, unit,"Pending",ppt);
			
			myTransactions.add(ttr);
			

			return myTransactions;
		
		}




			

		
		
		


	//@Override
	//public void deleteAccount(String username,Map<String, Customer> customers) throws InputInvalidException {
		// TODO Auto-generated method stub
		
		
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
