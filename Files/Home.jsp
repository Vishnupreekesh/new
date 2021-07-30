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
		<form action="Signout.jsp" method="post">
			<%@ page import="javax.servlet.http.HttpSession" %>
			<%@ page import="Main.User"%>
			<%@ page import="Main.Connector"%>
			<%@ page import="java.util.ArrayList" %>
			
			
			<%
			 
				String id=(String)session.getAttribute("id");
				User obj=(User)request.getAttribute(id);
				
  				out.print("<h3>Hello "+obj.getFirstname()+" "+obj.getLastname()+"</h3>");  
  				
  				out.print("<h4>Email :<h4>");
  				ArrayList<String> li=obj.getEmail();
  				
  				for(int i=0;i<li.size();i++){
  					out.print("<h4>"+li.get(i)+" "+"<h4>");
  				}
				
			%>
		
			<input type="submit" class="button" value="Logout"><br>
			
		</form>
		
		<form action="Profile.jsp" method="post">
		
			<br><input type="submit" class="button" value="Profile">
		
		</form>
		
		<form action="ResetPass.jsp" method="post">
		
			<br><input type="submit" class="button" value="Reset Password">
		
		</form>
		
		</div>
</body>

</html>