package com.masai;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.masai.entities.Customer;
import com.masai.entities.Product;
import com.masai.entities.Transaction;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.ProductException;
import com.masai.exceptions.InputInvalidException;
import com.masai.exceptions.TransactionException;
import com.masai.service.CustomerService;
import com.masai.service.CustomerServiceImpl;
import com.masai.service.CustomerServiceImple;
import com.masai.service.ProductService;
import com.masai.service.ProductServicesImpl;
import com.masai.service.TransactionService;
import com.masai.service.TransactionServiceImpl;
import com.masai.service.AdminService;
import com.masai.service.AdminServiceImple;
import com.masai.utility.Admin;
import com.masai.utility.FileExists;
import com.masai.utility.IDGen;

public class Main {
	
	//administration function
	private static void adminFunctionality(Scanner sc, Map<Integer, Product> products, Map<String, Customer> customers,
			List<Transaction> transactions) throws InvalidDetailsException, InputInvalidException, TransactionException {
		// admin login

		adminLogin(sc);

		AdminService prodService = new AdminServiceImple();
		CustomerService cusService = new CustomerServiceImple();
		//TransactionService trnsactionService = new TransactionServiceImpl();
		int choice = 0;
		try {
			do {
				
				System.out.println("Press 1 view all consumers");
				System.out.println("Press 2 View the bill of the consumer");
				System.out.println("Press 3 View all the bills");
				System.out.println("Press 4 View all bills paid and pending");
				System.out.println("Press 5 Delete consumer ");
				System.out.println("Press 6 to log out");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					String added = adminAddProduct(sc, products, prodService);
					System.out.println(added);
					break;
				case 2:	adminViewAllCustomers(customers, cusService);
					    break;
			/*	
				
				case 5:
					adminViewAllCustomers(customers, cusService);

					break;
				case 6:
					adminViewAllTransactions(transactions, prodService);
					break;*/
				case 6:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}

			} while (choice <= 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String adminAddProduct(Scanner sc, Map<Integer, Product> products, AdminService prodService) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	private static void adminViewAllCustomers(Map<String, Customer> customers, CustomerService cusService) {
		// TODO Auto-generated method stub
		
	}

	public static void adminLogin(Scanner sc) throws InvalidDetailsException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailsException("Invalid Admin Credentials");
		}
	}	
	
	
	

	
	
	
	
	
	// customer functionality
	public static void customerFunctionality(Scanner sc, Map<String, Customer> customers,
			Map<Integer, Product> products, List<Transaction> transactions)
			throws InvalidDetailsException, TransactionException {

		AdminService prodService = new AdminServiceImple();
		CustomerService cusService = new CustomerServiceImple();
		//TransactionService trnsactionService = new TransactionServiceImpl();

		// Customer login
		System.out.println("please enter the following details to login");
		System.out.println("please enter the Username");
		String Uname = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		customerLogin(Uname,pass, customers, cusService);

		try {
			int choice = 0;
			do {
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to view Balance");
				System.out.println("Press 2 to view my details");
				System.out.println("Press 3 to view my transactions");
				System.out.println("Press 4 to generate bill");
				System.out.println("Press 5 to pay Money in balance");
				System.out.println("Press 6 to logout");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					double Balance = viewBalance(Uname, customers, cusService);
					System.out.println("Wallet balance is: " +Balance);
					break;
				
				case 2:
					customerViewMyDetails(Uname, customers, cusService);
					break;
				
				case 3:
					customerViewCustomerTransactions(Uname, transactions, cusService);
					break;
				//case 4:
					//String result = customerBillProduct(sc, Uname, products, customers, transactions, cusService);
					//System.out.println(result);
					//break;
				case 5:
					String moneyAdded = customerAddMoneyToBalance(sc, Uname, customers, cusService);
					System.out.println(moneyAdded);
					break;
				
				case 6:
					System.out.println("you have successsfully logout");
					break;
				default:
					System.out.println("invalid choice");
					break;
				}

			} while (choice <= 5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	



	private static String customerBillProduct(Scanner sc, String uname, Map<Integer, Product> products,
			Map<String, Customer> customers, List<Transaction> transactions, CustomerService cusService) throws InvalidDetailsException, InputInvalidException {
		// TODO Auto-generated method stub
		System.out.println("please enter the Units of Electricity in KWh");
		int units = sc.nextInt();
		cusService.generateBill(id, units,uname, products,customers,transactions);
		
		
		return "You have successfully paid the bill" ;
	}

	private static String customerAddMoneyToBalance(Scanner sc, String uname, Map<String, Customer> customers,
			CustomerService cusService) {
		// TODO Auto-generated method stub
		
		System.out.println("please enter the amount");
		double money = sc.nextDouble();
		cusService.payMoney(money, uname, customers);
		
		
		
		return "Amount: " + money +" successfully added to your Balance";
	}

	private static void customerViewCustomerTransactions(String uname, List<Transaction> transactions,
			CustomerService cusService) throws TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> myTransactions = cusService.customerViewCustomerTransactions(uname, transactions);

		for (Transaction tr : myTransactions) {
			System.out.println(tr);
		}
		
	}

	private static void customerViewMyDetails(String uname, Map<String, Customer> customers,
			CustomerService cusService) {
		// TODO Auto-generated method stub
		Customer cus = cusService.viewCustomerDetails(uname, customers);		
		System.out.println("First name : " + cus.getFirstname());
		System.out.println("Last name : " + cus.getLastname());
		System.out.println("Username : " + cus.getUsername());
		System.out.println("Address : " + cus.getAddress());
		System.out.println("Email : " + cus.getEmail());
		System.out.println("Mobile no. : " + cus.getMobile());
		System.out.println("balance : " + cus.getBalance());
		
		
	}

	private static double viewBalance(String uname, Map<String, Customer> customers, CustomerService cusService) {
		// TODO Auto-generated method stub
		double Balance = cusService.viewBalance(uname, customers);
		return Balance;
	}

	//customer Signup
	public static void customerSignup(Scanner sc, Map<String, Customer> customers) throws DuplicateDataException {
		System.out.println("please enter the following details to Signup");
		System.out.println("please enter the first name");
		String fname = sc.next();
		System.out.println("please enter the last name");
		String lname = sc.next();
		String uname=""+IDGen.generateUsername();
		String pwd=""+IDGen.generatePassword();
		
		System.out.println("Enter the address");
		String address = sc.next();
		System.out.println("Enter the Mobile.no.");
		String mob = sc.next();
		System.out.println("Enter the email id");
		String email = sc.next();
		
		Customer cus = new Customer(0,fname,lname,uname,pwd,address,mob,email);

		CustomerService cusService = new CustomerServiceImple();
		cusService.signUp(cus, customers);
		System.out.println("Customer Username:"+uname);
		System.out.println("Customer Password:"+pwd);

	}
	
	public static void customerLogin(String username,String pass, Map<String, Customer> customers, CustomerService cusService)
			throws InvalidDetailsException {
		cusService.login(username, pass,customers);
		System.out.println("Customer has successfully login");

	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Product> products = FileExists.productFile();
		Map<String, Customer> customers = FileExists.customerFile();
		List<Transaction> transactions = FileExists.transactionFile();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Electricity Bill Payment System");
		
		try {

			int input = 0;
			do {
				System.out.println("Please enter , " + " '1' --> Admin login , '2' --> Customer login , "
				+ "'3'-----> for Customer signup, '0'---> for exit");
				input = sc.nextInt();
				switch (input) {
				case 1:
					adminFunctionality(sc, products, customers, transactions);
					break;
				case 2:
					customerFunctionality(sc, customers, products, transactions);
					break;

				case 3:
					customerSignup(sc, customers);
					break;

				case 0:
					System.out.println("successfully existed from the system");

					break;

				default:
					throw new IllegalArgumentException("Invalid Selection");
				}

			}while (input != 0);
		
		     } catch (Exception e) {
			      System.out.println(e.getMessage());
		     }
		finally {
			
			try {
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Product.ser"));
				poos.writeObject(products);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
				coos.writeObject(customers);

				ObjectOutputStream toos = new ObjectOutputStream(new FileOutputStream("Transactions.ser"));
				toos.writeObject(transactions);
			//	System.out.println("serialized");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
	
			
	}

}
