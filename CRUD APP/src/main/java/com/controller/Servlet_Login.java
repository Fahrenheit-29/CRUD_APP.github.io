package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao_Login;
import com.pojo.POJO;


@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Validate.jsp").forward(request, response);
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("user");
		String password= request.getParameter("password");
		
	
		if (username.equals("") || username.equals(null) || password.equals("") || password.equals(null)) {
		request.getSession().setAttribute("req", "INput Require Field");
			//request.setAttribute("required", "Input Required Field");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
response.sendRedirect("Welcome");
		}
	
		else {
			POJO pojo= new POJO(username,password);
			Dao_Login log= new Dao_Login();
			ResultSet rs=log.form_login(pojo);
			HttpSession session = request.getSession(true);
			try {
				if (rs.next()) {
					
					
				//	HttpSession session = request.getSession(true);
					session.setAttribute("user1", rs.getString(1));
					
					session.setAttribute("pass", rs.getString(2));
					session.setMaxInactiveInterval(20);
				
					
				response.sendRedirect("Home");
				
				}
				else {
				
				
				
	
						request.getSession().setAttribute("req", "Incorrect Username and Password");
					session.setAttribute("user22", pojo.getUser());
				
						//request.setAttribute("req", "Incorrect Username and Password");
						//request.getRequestDispatcher("Welcome").forward(request, response);
					//response.sendRedirect("Welcome");
				
					response.sendRedirect("Servlet_Login");
					
					
				}
			
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Something Wrong");
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}

