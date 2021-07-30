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
<%@ page import="java.util.Date" %> 
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
			
<% 
    String id=(String)session.getAttribute("id");
    User obj=(User)request.getAttribute(id);
    
    
	out.print("<h3>Hello "+obj.getFirstname()+" "+obj.getLastname()+"</h3>");  
	
	HashMap<Date,Integer> hm=(HashMap<Date,Integer>)session.getAttribute("session");
	for(Map.Entry m : hm.entrySet()){    
		if(id.equals(m.getValue())){
	 	   out.println(m.getKey());  
	%>
	
	<form action="Signout.jsp" method="post">
		<input type="submit" class="button" value="Logout"><br>
	</form>
	
	<%
		}
	}
%>


<form action="Logout.jsp" method="post">
	<br><input type="submit" class="button" value="Logoutallthesession"><br>
</form>

</body>
</html>