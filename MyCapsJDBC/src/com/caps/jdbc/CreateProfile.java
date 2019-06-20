package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CreateProfile {

	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt  = null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the S_no");
		int S_no=sc.nextInt();
		System.out.println("Enter the Real_name");
		String rname=sc.next();
		System.out.println("Enter the Actor_name");
		String aname=sc.next();
		System.out.println("Enter the Actor_price");
		int price=sc.nextInt();	
		
		try
		{
			
//1. Load the Driver Class
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		//2. Get DBConnection via Driver
			
			String path="E:/Caps_Traning/DBCredintials.Properties";
			FileReader reader=new FileReader(path);
			Properties prop=new Properties();
			prop.load(reader);
			
			String dburl="jdbc:mysql://localhost:3306/Captain_marvel";
			con = DriverManager.getConnection(dburl, prop);
			
		//3. Issue SQL Querries via Connection
			
			String querry="insert into Actor_table values(?,?,?,?)";
			pstmt=con.prepareStatement(querry);
			pstmt.setInt(1,S_no);
			pstmt.setString(2,rname);
			pstmt.setString(3,aname);
			pstmt.setInt(4,price);
			
			int count=pstmt.executeUpdate();

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
		}
		finally
		{
			
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}

}

