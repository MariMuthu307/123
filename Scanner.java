package org.m;

import java.util.Scanner;

public class Pratice {
	
	public static void main(String[] args) {
		
		Scanner m = new  Scanner(System.in);
		
		System.out.println("Enter Your Name :");
		String name = m.next();
		
		
		System.out.println("Enter your last name :");
		String lastname = m.next();
		
		System.out.println("Enter Your DOB");
		int dob = m.nextInt();
		
		System.out.println("Enter your PhoneNYumber");
		long num = m.nextLong();
		
		System.out.println("Enter your Address");
		String add = m.next();
		
		System.out.println("Enter Your PIN Code");
		int pin = m.nextInt();
		
		System.out.println("Employee name:"+name);
		System.out.println("Employee Last Namemari :"+lastname);
		System.out.println(dob);
		System.out.println(num);
		System.out.println(add);
		System.out.println(pin);
	}
	
	
	
	
	

}
