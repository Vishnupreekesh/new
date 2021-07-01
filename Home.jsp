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
		Cookie cookies=null;
  		Cookie[] cookie=request.getCookies();
  		System.out.print(cookie[0].getValue());
		for(int i=0;i<cookie.length;i++){
			cookies=cookie[i];
			if(cookies.getName().equals("FName")||cookies.getName().equals("Sname")){
			out.println("<h1>Welcome "+cookies.getValue()+"<h1>");
			}
		}
%>
</html>