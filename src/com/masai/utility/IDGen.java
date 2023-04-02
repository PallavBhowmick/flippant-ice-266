package com.masai.utility;
import java.time.LocalDate;

public class IDGen {
	
	public static int generateId() {


		return (int) (Math.random() * 100000000);
	}

}
