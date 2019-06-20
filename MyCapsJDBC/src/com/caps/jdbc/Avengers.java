package com.caps.jdbc;



import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Avengers {
	
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt  = null;
		ResultSet rs = null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the class name");
		String name=sc.next();
//		System.out.println("Enter the UserName");
//		String user=sc.next();
//		System.out.println("Enter the PassWord");
//		String pass=sc.next();
		
		
		try 
		{
		//1. Load the Drive Class
			
			//1. Load the Driver class
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. Estd the Connection via Driver
			
			String path="E:/Caps_Traning/DBCredintials.Properties";
			FileReader reader=new FileReader(path);
			Properties prop=new Properties();
			prop.load(reader);
			
			String dburl="jdbc:mysql://localhost:3306/Captain_marvel";
			con=DriverManager.getConnection(dburl, prop);
			
		//3.Issue the sql query via connection
			
			String query = "select * from Actor_table";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
		//Process the result returned by sql query
			
			while(rs.next())
			{
				int no = rs.getInt("s_no");
				String rname = rs.getString("Real_name");
				String aname = rs.getString("Actor_name");
				int price = rs.getInt("Actor_price");
				
				System.out.println(no);
				System.out.println(rname);
				System.out.println(aname);
				System.out.println(price);
				System.out.println("***************");
			}
						
			
			
		}catch(Exception e) 
		{
			
			e.printStackTrace();
			
		}finally 
		{
			
		}
		
		
	}

}
