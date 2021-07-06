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
<% 
	
	String name=(String)session.getAttribute("name");  
	out.print("<h3>Hello, "+name+"</h3><br>");  


%>

</body>
</html>