package com.Controller;

import java.io.IOException;

import com.Dao.UserInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/signup")
public class Signup extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		String mail = req.getParameter("email");
		
		UserInfoDao uDao = new UserInfoDao();
		boolean status = uDao.addUser(name, pass, mail);
		
		HttpSession s = req.getSession();
		
		if(status)
		{
			s.setAttribute("msg", "Account Created Successfully...");
			resp.sendRedirect("index.jsp");
		}
		else
		{
			s.setAttribute("msg", "Account Creation Failed...");
			resp.sendRedirect("index.jsp");
		}
		
	}

}
