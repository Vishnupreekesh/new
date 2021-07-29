<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="Main.Password"%>
<%@ page import="Main.User"%>
<%@ page import="Main.Connector"%>
<%@ page import="sqldatabase.Query" %>
<%

	String oldpassword=Password.doHashing(request.getParameter("oldpass"));
	String newpassword=Password.doHashing(request.getParameter("newpass"));
	String conformpass=Password.doHashing(request.getParameter("conformnewpass"));
	String email=(String)session.getAttribute("name");  
	
	String id=(String)session.getAttribute("id");
	User obj=(User)request.getAttribute(id);
	if(obj.getPassword().equals(oldpassword)){
		if(newpassword.equals(conformpass)){
			if(Query.changePassword(email, newpassword)) {
				out.print("Changed Successfully");
			}
		}
		else{
			out.print("confirm password incorrect");
		}
	}
	else{
		out.print("Enter correct new password");
	}
	
%>

</body>
</html>