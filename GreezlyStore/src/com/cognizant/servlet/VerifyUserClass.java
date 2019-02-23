package com.cognizant.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyUserClass {

	
	public static boolean findAdmin(String uname,String pword)
	{
		
		boolean status=false;  
		Connection connection =null;
		PreparedStatement statement = null;
		ResultSet resultSet =null;
		
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
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sam","newsam");
			statement=connection.prepareStatement("select * from admin_table where admin_username=? and admin_password=?");
			statement.setString(1,uname);
			statement.setString(2,pword);
			resultSet=statement.executeQuery(); 
			
			
			if(resultSet.next())
			{
				int accstatus = resultSet.getInt(3);
				if(accstatus==1)
				{
					status =true;
				}
				else
				{
					status = false;
				}
			}
			else
			{
				status =false;
			}
			
			
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
		return status;  
	}

}

