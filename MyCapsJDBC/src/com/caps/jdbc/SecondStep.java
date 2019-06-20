package com.caps.jdbc;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class SecondStep {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Class Name");
		String name=sc.next();
		
		
		try
		{
		
		//1. Load the Driver class
			
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. Estd the Connection via Driver
		
		String path="E:/Caps_Traning/DBCredintials.Properties";
		FileReader reader=new FileReader(path);
		Properties prop=new Properties();
		prop.load(reader);
		
		String dburl="jdbc:mysql://localhost:3306:Captain_marvel";
		DriverManager.getConnection(dburl, prop);
		
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			
		}
	}

}
