package com.cognizant.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
public class AddProductDetailsClass {

	Connection conn = null;
	ResultSet rs =null;
	PreparedStatement ps =null;
	public static boolean addProduct(String username)
	{
		boolean result =false;
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sam","newsam");
		//	ps=connection.prepareStatement("insert into admin_table where admin_username=? );
		//	ps.setString(1,username);
			
			
			
			
			
			
		}	
			
		
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally 
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
