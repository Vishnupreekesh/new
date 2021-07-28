<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="resetpassword.jsp" method="post">
		<input type="password" class="input-box" name="oldpass"
						placeholder="Enter Old Password"><br>
						
		<input type="password" class="input-box" name="newpass"
						placeholder="Enter New Password"><br>
	
		<input type="password" class="input-box" name="conformnewpass"
						placeholder="confirm New Password"><br>
						
		<input type="submit" class="button" value="submit"><br>
	</form>

</body>
</html>