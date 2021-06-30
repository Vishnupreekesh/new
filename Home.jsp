<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
</head>
<body>
</body>
<%@ page import="Main.User" %>
<%
  		User user=(User)request.getAttribute("User");
		String str=user.getName();
		out.print("Welcome "+str);
%>
</html>