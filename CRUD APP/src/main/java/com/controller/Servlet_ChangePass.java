package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao_ChangePass;
import com.pojo.POJO;

@WebServlet("/Servlet_ChangePass")
public class Servlet_ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_ChangePass() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		request.getRequestDispatcher("ChangePassword").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String oldpassword = request.getParameter("oldpass");
		String newpassword = request.getParameter("newpass");
		String confirmpassword = request.getParameter("renewpass");
		
		HttpSession session= request.getSession(false);
		String current= (String) session.getAttribute("pass");
		

		if (username.equals("") || username.equals(null) || oldpassword.equals("") || oldpassword.equals(null)
				|| newpassword.equals("") || newpassword.equals(null) || confirmpassword.equals("")
				|| confirmpassword.equals(null)) {
			
				request.getSession().setAttribute("field", " <script> alert('All field are required to input'); </script>");
			response.sendRedirect("Servlet_ChangePass");
				
		}
		else if (!current.equals(oldpassword)) {
			request.getSession().setAttribute("field", "Oldpass is not Correct");
			response.sendRedirect("Servlet_ChangePass");
			
		}
	    else if (!newpassword.equals(confirmpassword)) {
				request.getSession().setAttribute("field", "Password Does not Match");
				response.sendRedirect("Servlet_ChangePass");
				
			
			
		}
	    else {
	    	
	    	POJO pojo =new POJO(username,newpassword);
	    	Dao_ChangePass passchange= new Dao_ChangePass();
	    	int i=passchange.changepass(pojo);
	    
	    	if(i>0) {
	    		
	    		
	    		
	    		request.getSession().setAttribute("field", "<script> alert('Change Pass Successfull'); </script>");
	    	
				response.sendRedirect("Home2.jsp");
	    	}
	    	else {
	    		
	    		request.getSession().setAttribute("field", "Cant change Password");
	    		response.sendRedirect("Servlet_ChangePass");
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    }


	}

}
