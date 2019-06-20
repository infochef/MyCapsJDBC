package com.caps.jdbc;

	import java.io.FileReader;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.util.Properties;

	public class BatchTest {

		public static void main(String[] args) {
			
			Connection con = null;
			Statement stmt = null;
			try
			{
				
				//1.Step: Loads The Driver Class
				Class.forName("com.mysql.jdbc.Driver");
				
				//2.Step: Estb the connection via Driver
				String path = "E:/Caps_Traning/DBCredintials.Properties";
				FileReader reader = new FileReader(path);
				Properties prop = new Properties();
				prop.load(reader);
				
				String dburl = "jdbc:mysql://localhost:3306/captain_marvel";
				con = DriverManager.getConnection(dburl,prop);
				
				stmt = con.createStatement();
				String query1 = "insert into Stone_table values(9,'Reality','Red',50)";
				stmt.addBatch(query1);
				
				String query2 = "insert into Stone_table values(10,'Power','purple',60)";
				stmt.addBatch(query2);
				
				String query3 = "insert into Stone_table values(11,'Reality','Pink',80)";
				stmt.addBatch(query3);
				
				int [] count = stmt.executeBatch();
				
				System.out.println("added");
			
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				
			}
			
			
			
			
		}
	}


