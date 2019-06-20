package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
public class Demo {
	public static void main(String[] args) {

        Connection con=null;
		Statement stmt  = null;
		ResultSet rs = null;
		try
		{
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
			String query = "select * from Stone_table";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			//Process the result returned by sql query
			while(rs.next())
			{
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

		}catch(Exception e)
		{
			
		   e.printStackTrace();
		}
		finally
		{
			
		}
}
}

		
		














