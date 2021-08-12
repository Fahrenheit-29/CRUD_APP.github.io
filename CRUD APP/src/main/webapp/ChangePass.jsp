<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change Password</title>
</head>
<body>
<%if (session.getAttribute("user1")==null){
	
	response.sendRedirect("admin");
}
else{
	
	
	response.setHeader("Cache-Control", " no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);
}%>



<form action="<%=request.getContextPath()%>/Servlet_ChangePass" method="post">

<input type="text" name="user" placeholder="Username" required>
<br>
<input type="text" name="oldpass" placeholder="Old Password">
<br>
<input type="text" name="newpass" placeholder="New Password">
<br>
<input type="text" name="renewpass" placeholder="Confirm Password">
<br>

	<%if (session.getAttribute("field")!=null){ %>
		
		
		
	<p>${field}</p>
	
		<% session.removeAttribute("field");
		
	
	}%>
	
	

<button>Submit</button>





</form>
</body>
</html>