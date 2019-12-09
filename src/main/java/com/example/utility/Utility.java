package com.example.utility;

public class Utility {

	
	
	
	public static String generateRegistrationNumber(String orgName) {
		double num=Math.random();
		String generatedRegNum=orgName.substring(0, 2)+Double.toString(num);
		return generatedRegNum;
	}
	
	
	
}
