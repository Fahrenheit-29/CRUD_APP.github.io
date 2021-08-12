<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
    
    <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/404.css">
<title>Error Page</title>

</head>

<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

%>
   
<div class="container">


		

		<div class="content">
		
		<p><font color="red"><%=exception.getMessage()  %></font></p>
		<p><font color="red"><%=exception.printStackTrace()  %></font></p>
		
			<h1>
			<a href="#">BACK</a>
			</h1>



		</div>

	</div>


<br>


<body>

</body>
</html>