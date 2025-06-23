package com.Controller;

import java.io.IOException;

import com.Dao.NoteInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addnote")
public class AddNote extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String note = req.getParameter("note");
		
		
		NoteInfoDao nDao = new NoteInfoDao();
		nDao.insertNote(note, name);
		
		resp.sendRedirect("home.jsp");
	}

}
