package com.Controller;

import java.io.IOException;

import com.Dao.NoteInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletenote")
public class DeleteNote extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noteid = req.getParameter("noteid");
		
		NoteInfoDao nDao = new NoteInfoDao();
		nDao.deleteNote(noteid);
		
		resp.sendRedirect("home.jsp");
	}

}
