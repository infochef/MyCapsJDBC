package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class FirstStep {
	
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the name of class");
	String name=sc.next();
	System.out.println("Enter the username");
	String user=sc.next();
	System.out.println("Enter the password");
	String pass=sc.next();
	
	try {
		
		//1. Loads the Driver Class
		
		/*java.sql.Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
				*/
		
		java.sql.Driver d=(java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
		DriverManager.registerDriver(d);
		
		//2. Get the Connection via Driver
		
		/*String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		Connection con = DriverManager.getConnection(dburl);
		System.out.println("Connection Established");
		*/
	
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		Connection con = DriverManager.getConnection(dburl,user,pass);
		System.out.println("Connection Established");
		
		
		
		
		
	}catch(Exception e)
	{
		
	}finally 
	{
		
	}
} 
	
}
