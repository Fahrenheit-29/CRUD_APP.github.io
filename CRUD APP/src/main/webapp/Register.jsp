<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD APP</title>
</head>
<body>


<%if (session.getAttribute("user1")!=null){
	
	response.sendRedirect("Home");
	
}%>

<%		
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
response.setDateHeader("Expires", -1); %>

<form action="<%=request.getContextPath()%>/Servlet_Registration" method="post" >
	
	
	<input type="text" name="r_user" placeholder="Enter Username" required="required">
	<input type="text" name="r_pass" placeholder="Enter Password" required="required">
	<input type="text" name="r_confirm" placeholder="Confirm Password"  required="required">
	
	
	
	<% if (request.getSession().getAttribute("reg")!=null) {%>
	
	
	<p>${reg}</p>
	
	
	
	<% request.getSession().removeAttribute("reg"); 
	} %>
	
	<button>Submit</button>
</form>



</body>
</html>