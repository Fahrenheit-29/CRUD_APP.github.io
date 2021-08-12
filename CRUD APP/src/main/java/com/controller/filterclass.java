/*package com.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class filterclass implements Filter {

    public filterclass() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest  req= (HttpServletRequest) request;
		HttpServletResponse  res= (HttpServletResponse) response;
		
		if (req.getSession().getAttribute("user1")== null) {
			
			res.sendRedirect("index.jsp");
			
		}
		else {
			System.out.println("Invalid");
			chain.doFilter(request, response);	
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
*/
