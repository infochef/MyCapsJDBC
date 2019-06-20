package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;


public class StaticQuerry {
	
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt  = null;
			    
	    
		try
		{
		
		//1. Load the Driver Class
			
			Class.forName("com.mysql.jdbc.Driver");
			
		//2. Get DBConnection via Driver
			
			String path="E:/Caps_Traning/DBCredintials.Properties";
			FileReader reader=new FileReader(path);
			Properties prop=new Properties();
			prop.load(reader);
			
			String dburl="jdbc:mysql://localhost:3306/Captain_marvel";
			con = DriverManager.getConnection(dburl, prop);
			
		//3. Issue SQL Querries via Connection
			
			String querry="insert into Actor_table values(7,'Jeremy Renner','Clint Barton',80)";
			stmt=con.createStatement();
			int count=stmt.executeUpdate(querry);
			
			if(count>0)
			{
				System.out.println("Data Added");
			}
			else
			{
				System.err.println("Something went wrong");
			}
			
		}catch(Exception e)
		{
		
			e.printStackTrace();
			
			
		}finally
		{
			
		}
		
	}

}
