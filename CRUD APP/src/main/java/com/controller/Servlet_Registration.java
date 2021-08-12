package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao_Connect;
import com.dao.Dao_Registration;
import com.pojo.Register_User;

@WebServlet("/Servlet_Registration")
public class Servlet_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("Register").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int i;
		String username = request.getParameter("r_user");
		String password = request.getParameter("r_pass");
		String confirmpass = request.getParameter("r_confirm");

		if (username.equals("") || username.equals(null) || password.equals("") || password.equals(null)
				|| confirmpass.equals("") || confirmpass.equals(null)) {
			
			//request.setAttribute("register", "   <script> alert('All fields are Required'); </script>");
			//request.getRequestDispatcher("Register.jsp").forward(request, response);
		request.getSession().setAttribute("reg","<script> alert('All fields are Required'); </script>" );
			response.sendRedirect("Servlet_Registration");
		}
		else if (!password.equals(confirmpass)) {
			request.getSession().setAttribute("reg","<script> alert('Password Doesnt Match'); </script>" );
			response.sendRedirect("Servlet_Registration");
		
			
		}
		else {
		
		
			Dao_Connect connect= new Dao_Connect();
			Connection con=connect.database();
			PreparedStatement ps;
			Register_User register= new Register_User();
			register.setUsername(username);
			register.setPassword(password);
			register.setConfirmpassword(confirmpass);
			try {
				
				String q1="SELECT * FROM crud_app.mvc_crud WHERE username='"+username +"'";
					
				 ps =con.prepareStatement(q1);
				
				ResultSet rs= ps.executeQuery();
				
				if (rs.next()) {
					
					request.getSession().setAttribute("reg", "<script> alert('Username Already Exist'); </script>");
					
					response.sendRedirect("Servlet_Registration");
					System.out.println("username already exist");
				}
				else {
			 
					
					
				Dao_Registration reg= new Dao_Registration();
				i=reg.register(register);
				
				if (i!=0) {
					request.getSession().invalidate();
					response.sendRedirect("Welcome");
				
					System.out.println("redirected to Welcome");
					
				}
				else {
				

					request.getSession().setAttribute("reg", "<script> alert('Can`t Register'); </script>");
					
					response.sendRedirect("Servlet_Registration");
					
					System.out.println("D maka register");
				}
				
				}
				
				
			}catch(SQLException er) {
				System.out.println(er.getMessage());
			} 
			
			catch (Exception e) {
				e.getMessage();
			}
			
	
	
			
			
		}
		
		
	}
	
	

}
