<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.controller.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <title>CRUD APP</title>
 
</head>
  <!--  <script type="text/javascript">
        function disableBack() {
            window.history.forward();
        }
        setTimeout("disableBack()", 0);
        window.onunload = function() {
            null
        };
    </script> -->
<body>






<% 
	

String user= (String) session.getAttribute("user1");
	
	if (user==null){
		
		response.sendRedirect("Welcome");
	}
	else if (session.getAttribute("field")!=null){%>
		
		<p>${field}</p>
		
	<% session.removeAttribute("field"); }
	
	else {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setDateHeader("Expires", -1);
	}
%>
		 
<%


%>

  <div class="container">

        <div class="main">
            <div class="layout-1">
                <div class="bg">
                    <nav>
                        <ul>
                            <li>
                                <a href="Home">Home</a></li>
                            <li>
                                <a href="#">Save</a></li>
                            <li>
                                <a href="#">View</a></li>
                            <li class="drpdown">
                                <a href="#">Account</a>
                                <div class="drp_content">
                                    <a href="Servlet_Logout">Logout</a>
                                    <a href="ChangePassword">Change Password</a>
                                </div>
								


                            </li>
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







            <div class="layout-3">3
              
            </div>
            <div class="layout-4">4
               
            </div>

        </div>


    </div>


</body>

</html>