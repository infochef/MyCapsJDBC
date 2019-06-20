package com.caps.jdbc;


	import java.io.FileReader;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
	import java.util.Scanner;

	public class UpdateQuerry {

		private static final String Stone_name = null;

		public static void main(String[] args) {
			
			Connection con=null;
			PreparedStatement pstmt=null;
			
			Scanner sc=new Scanner(System.in);
//			System.out.println("Enter the Class Name");
//			String name=sc.next();
			System.out.println("Enter the S_no");
			int S_no=sc.nextInt();
			System.out.println("Enter the Stone_name");
			String name=sc.next();
			
			
			try
			{
			
			//1. Load the Driver Class
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			//2. Get DB Connection via Driver
				
				String path="E:\\Caps_Traning\\DBCredintials.Properties";
				FileReader reader=new FileReader(path);
				Properties prop=new Properties();
				prop.load(reader);
				
				String dburl="jdbc:mysql://localhost:3306/Captain_marvel";
				con = DriverManager.getConnection(dburl,prop);
				
			//3. Issue SQL Queries via Connection
				
				String querry="UPDATE Stone_table SET Stone_name=? WHERE S_no=?";
						
						
				pstmt=con.prepareStatement(querry);
				pstmt.setString(1,name);
				pstmt.setInt(2,S_no);
				
				int count=pstmt.executeUpdate();
				if(count>0)
				{
					System.out.println("Data Updated");
				}
				else
				{
					System.err.println("Something went Wrong");
				}
						
			}catch(Exception e)
			{
			
				e.printStackTrace();
				
			}finally
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

