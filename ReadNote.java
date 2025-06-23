package com.Controller;

import java.io.IOException;

import com.Dao.NoteInfoDao;
import com.Entity.Note;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/readnote")
public class ReadNote extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String noteid = req.getParameter("noteid");
		
		NoteInfoDao nDao = new NoteInfoDao();
		Note note = nDao.readNote(noteid);
		
		HttpSession s = req.getSession();
		s.setAttribute("n", note);
		
		resp.sendRedirect("home.jsp");
		
	}

}
