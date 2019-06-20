package com.caps.jdbc;


	import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

	public class CallableTest {
		
		public static void main(String[] args) {
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
			
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
				String query = "call getAllStone()";
				cstmt = con.prepareCall(query);
			    boolean b = cstmt.execute();
			    
			    if(b)
			    {
			    	rs = cstmt.getResultSet();
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
			    }
			    else
			    {
			    	int count=cstmt.getUpdateCount();
			    	if(count>0)
			    	{
			    		
			    	}
			    	else
			    	{
			    		
			    	}
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
				if(cstmt!=null)
				{
					try {
						cstmt.close();
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
