package com.Controller;

import java.io.IOException;

import com.Dao.UserInfoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		
		UserInfoDao uDao = new UserInfoDao();
		boolean status = uDao.checkUser(name, pass);
		
		HttpSession s = req.getSession();
		
		if(status)
		{
			s.setAttribute("token", name);
			resp.sendRedirect("home.jsp");
		}
		else
		{
			s.setAttribute("msg", "Invalid Credentials");
			resp.sendRedirect("login.jsp");
		}
		
	}

}
