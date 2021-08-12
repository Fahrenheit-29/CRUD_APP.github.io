package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_Logout")
public class Servlet_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if (session!=null) {
			
			session.invalidate();
			
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
		//request.getRequestDispatcher("Home.jsp").forward(request, response);
			response.sendRedirect("Welcome");
			
		}
		
		
	}

	
}
