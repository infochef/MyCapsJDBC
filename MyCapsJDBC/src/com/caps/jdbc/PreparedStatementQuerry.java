package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class PreparedStatementQuerry {
	
	public static void main(String[] args) {
		
		 Connection con=null;
			PreparedStatement pstmt  = null;
			ResultSet rs = null;
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the S_no");
		int S_no=sc.nextInt();
		
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
			
            //3. Issue SQL Queries via Connection
			
			String query="Select * from Stone_table Where S_no = ? ";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,S_no);
			rs=pstmt.executeQuery();
			
			//Process the result returned by sql query
			while(rs.next())
			{
				int no = rs.getInt("s_no");
				String name1 = rs.getString("Stone_name");
				String color = rs.getString("Stone_color");
				int price = rs.getInt("Stone_price");

				System.out.println(no);
				System.out.println(name1);
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
				if(rs!=null)
				{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}

}
}

		
		














