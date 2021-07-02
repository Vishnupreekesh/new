<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>

<body>
		<div class="signinform">
		<form action="Home" method="post">
			<%@ page import="javax.servlet.http.HttpSession" %>
			<%
			String name=(String)session.getAttribute("name");  
				if(name!=null){  	
					Cookie cookie = new Cookie("SESSIONID", session.getId());
					cookie.setMaxAge(Integer.MAX_VALUE);
					response.addCookie(cookie);
  					out.print("<h3>Hello, "+name+"</h3><br>");  
				}  
				else{  
    				out.print("Please login first");  
    				response.sendRedirect("Signin.html");
    			}  
			%>
			<input type="submit" class="button" value="Logout"><br>
			
		</form>
		
		<form action="profile" method="post">
		
			<br><input type="submit" class="button" value="Profile">
		
		</form>
		</div>
</body>

</html>