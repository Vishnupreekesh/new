<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>In Profile</h3>

<%@ page import="Main.User"%>
<%@ page import="Main.Connector"%>
<% 
	String name=(String)session.getAttribute("name");  
	User obj= Connector.signin(name);
	out.print("<h3>Hello "+obj.getFirstname()+" "+obj.getLastname()+"</h3>");  


%>

</body>
</html>