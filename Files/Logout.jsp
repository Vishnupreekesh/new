<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
	
	session.invalidate(); 
	response.sendRedirect("http://localhost:8081/userproject/Signin.html");


%>

</body>
</html>