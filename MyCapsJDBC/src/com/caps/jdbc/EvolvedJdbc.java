package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EvolvedJdbc { 
	
	public static void main(String[] args) {
		
		String dburl="jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		String sql="Select * from Stone_table";
		
		try( Connection con=DriverManager.getConnection(dburl);
			 Statement	stmt = con.createStatement();
			 ResultSet	rs =stmt.executeQuery(sql)){
		while(rs.next()){
			int no = rs.getInt("s_no");
			String name = rs.getString("Stone_name");
			String color = rs.getString("Stone_color");
			int price = rs.getInt("Stone_price");

			System.out.println(no);
			System.out.println(name);
			System.out.println(color);
			System.out.println(price);
			System.out.println("***************");
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught...");
			e.printStackTrace();
		}
	
}
}
