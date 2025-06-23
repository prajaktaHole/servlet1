package com.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	static Connection con;
	
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/mydb";
			String username = "root";
			String password="";
			
			con=DriverManager.getConnection(url, username, password);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally 
		{
			return con;
		}
	}

}
