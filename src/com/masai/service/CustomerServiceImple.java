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
import java.util.Set;

import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.InputInvalidException;
import com.masai.exceptions.TransactionException;
public class CustomerServiceImple implements CustomerService {
	@Override
	public void signUp(Customer cus, Map<String, Customer> customers) throws DuplicateDataException {

		if (customers.containsKey(cus.getUsername())) {
			throw new DuplicateDataException("Customer already exists , please login");
		} else {

			customers.put(cus.getUsername(), cus);

		}

	}
	@Override
	public boolean login(String username,String password, Map<String, Customer> customers) throws InvalidDetailsException {

		if (customers.containsKey(username) ) {
			
			if(customers.get(username).getPassword().equals(password)) {
				return true;
			}
			else {
				throw new InvalidDetailsException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailsException("you have not sign up yet, please signup");
		}

	}
	
	@Override
	public boolean generateBill(int id, String username, Map<Integer, Product> products,
			Map<String, Customer> customers, List<Transaction> transactions)
			throws InvalidDetailsException, InputInvalidException, TransactionException {
        boolean flag=false;
		if (transactions.size() == 0)
			throw new InputInvalidException("Please provide entry");
		Transaction ggt=new Transaction();
		double uu=0;
		if (products.containsKey(id)) {
			for (Transaction tr : transactions) {
				if (tr.getUsername().equals(username)) {
					ggt=tr;
					flag=true;
				}
			}
			
			if (flag == false) {
				throw new TransactionException("Please provide correct entry");
			}
			Product prod = products.get(id);

			if (prod.getId()==id ) {

				Customer cus = customers.get(username);
				uu=ggt.getUnit();
				double total =uu * 10;
				double bill= 80+total+(0.025*total)+cus.getBalance();

				if (cus.getBalance() >= bill) {
					cus.setBalance(cus.getBalance() - bill);

					prod.setUnit(uu);

					products.put(id, prod);
					
					for (Transaction tt : transactions) {
						if (tt.getUsername().equals(username) && tt.getStatus()=="Pending") {
							tt.setStatus("Paid");
							tt.setDt(LocalDate.now());
							tt.setEmail(cus.getEmail());
							tt.setUnit(uu);
					
						}
					}

					

				} 
				
				
				else {
						
					throw new TransactionException("balance is not sufficient please payMoney:"+(bill-cus.getBalance()));
				}

			} else {
				throw new InvalidDetailsException("Units entered in kWh is invalid");
			}

		} else {
			throw new InvalidDetailsException("product not available with id: " + id);
		}

		return false;
	}
	
	@Override
	public boolean payMoney(double amount, String username, Map<String, Customer> customers) {
		// TODO Auto-generated method stub

		Customer cus = customers.get(username);

		cus.setBalance(cus.getBalance() + amount);

		customers.put(username, cus);
		
		return true;
	}
	
	
	@Override
	public double viewBalance(String username, Map<String, Customer> customers) {
		// TODO Auto-generated method stub

		Customer cus = customers.get(username);

		return cus.getBalance();
	}
	
	public Customer viewCustomerDetails(String username, Map<String, Customer> customers) {

		if (customers.containsKey(username)) {

			return customers.get(username);

		}

		return null;
	}
	
	@Override
	public List<Transaction> customerViewCustomerTransactions(String username, List<Transaction> transactions)	throws TransactionException {
		List<Transaction> myTransactions = new ArrayList<>();

		boolean flag = false;
		for (Transaction tr : transactions) {
			if (tr.getUsername().equals(username)) {

				myTransactions.add(tr);

				flag = true;
			}
		}
		if (!flag) {
			throw new TransactionException("you have not done any transaction yet");
		}

		return myTransactions;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
