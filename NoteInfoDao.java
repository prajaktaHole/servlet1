package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.ConnectionFactory.ConnectionFactory;
import com.Entity.Note;

public class NoteInfoDao {
	
	
	public void insertNote(String note, String username)
	{
		try
		{
			String sql = "insert into noteinfo(note, username, add_date, Edit_date) values(?,?,?,?)";
			Connection con = ConnectionFactory.getCon();
			
			LocalDateTime dt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String add_date = dtf.format(dt);
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, note);
			ps.setString(2, username);
			ps.setString(3, add_date);
			ps.setString(4, "Note Attepmted");
			
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	
	public ArrayList<Note> readAllNotes(String username)
	{
		ArrayList<Note> al = new ArrayList<Note>();
		try
		{
			String sql = "select * from noteinfo where username = ?";
			Connection con = ConnectionFactory.getCon();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Note n = new Note();
		
				n.setNoteid(rs.getInt("noteid"));
				n.setNote(rs.getString("note"));
				n.setUsername(rs.getString("username"));
				n.setAdd_date(rs.getString("add_date"));
				n.setEdit_date(rs.getString("edit_date"));
				
				al.add(n);
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			return al;
		}
	}
	
	
	
	public void deleteNote(String noteid)
	{
		try
		{
			String sql = "delete from noteinfo where noteid=?";
			Connection con = ConnectionFactory.getCon();
			
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(noteid));
			
			
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	public Note readNote(String noteid)
	{
		Note n = null;
		try
		{
			String sql = "select * from noteinfo where noteid = ?";
			Connection con = ConnectionFactory.getCon();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(noteid));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				n = new Note();
		
				n.setNoteid(rs.getInt("noteid"));
				n.setNote(rs.getString("note"));
				n.setUsername(rs.getString("username"));
				n.setAdd_date(rs.getString("add_date"));
				n.setEdit_date(rs.getString("edit_date"));
				
	
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			return n;
		}
	}
	
	
	
	
	
	
	public void editNote(String noteid, String note)
	{
		try
		{
			String sql = "update noteinfo set note=?, edit_date=? where noteid=?";
			Connection con = ConnectionFactory.getCon();
			
			LocalDateTime dt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String edit_date = dtf.format(dt);
			
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, Integer.valueOf(noteid));
			ps.setString(1, note);
			ps.setString(2, edit_date);
			
			
			
			ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	

}
