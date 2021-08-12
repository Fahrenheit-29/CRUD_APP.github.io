<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap"
	rel="stylesheet">
<title>HOME</title>




</head>
<body>
<%
	

String user= (String) session.getAttribute("user1");
	
	if (user!=null){
		
		
		response.sendRedirect("Home");
		// first option to prevent back button after user log in response.sendRedirect("admin");  
		
	}
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	response.setDateHeader("Expires", -1);
	
	
	 %>
	

	





	<%

if (request.getAttribute("field")!=null){%>
	
	<p>${field}</p>
	
	
<%}%>

	

	

	<div class="container">

		<div class="main">
			<div class="layout-1">
				<div class="bg">
					<nav>
						<ul>
							<li><a href="Welcome">Home</a></li>
							<li><a href="#log">Login</a></li>
							<li><a href="#">About</a></li>
						</ul>
					</nav>




				</div>

			</div>




			<div class="layout-2">
				<div class="bg_title">
					<div class="title">
						<h1>CRUD APP</h1>

					</div>



				</div>

			</div>






			<div class="layout-3" id="Log">
			
				<form action="<%=request.getContextPath()%>/Servlet_Login" method="post" align="center">
																			

					<label>Username</label> <input type="text" name="user"
						placeholder="Username" required="required" value="${user1}"> <br> <br>
					<label>Password</label>

					<input type="password" name="password" placeholder="Password" required="required"> 
					<br> <br>
				<!--   <p>${required}</p> -->	
					<%if (session.getAttribute("req")!=null){%>
					
						<p id="marker">${req}</p>
				<% session.removeAttribute("req");
				
				}
					

				%>
					<button>Submit</button>
					<a href="Register">Register</a>

				</form>


			</div>
			<div class="layout-4">4</div>

				
				

		</div>


	</div>

</body>
</html>