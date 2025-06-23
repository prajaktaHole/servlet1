package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ConnectionFactory.ConnectionFactory;

public class UserInfoDao {
	
	boolean flag = false;
	
	public boolean addUser(String username, String password, String email)
	{
		try
		{
			String sql = "insert into userinfo values(?,?,?)";
			Connection con = ConnectionFactory.getCon();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			
			int row = ps.executeUpdate();
			
			if(row==1) flag = true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally {
			return flag;
		}
	}
	
	
	
	
	public boolean checkUser(String username, String password)
	{
		try
		{
			String sql = "select * from userinfo where username = ? and password=?";
			Connection con = ConnectionFactory.getCon();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) flag = true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			return flag;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
