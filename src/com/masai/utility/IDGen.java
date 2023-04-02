package com.masai.utility;
import java.time.LocalDate;

public class IDGen {
	
	public static int generateUsername() {
		return (int) (Math.random() * 100000000);
	}
	public static int generatePassword() {
		return (int) (Math.random() * 100000000);
	}
	public static int generateId() {
		return (int) (Math.random() * 100000000);
	}


}
