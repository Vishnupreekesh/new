package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Main.Connector;
import Main.Password;
import sqldatabase.Query;

public class ChangePass extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			PrintWriter out=response.getWriter();
			
			if(Connector.userAvailable(email)&&Password.validatePassword(password)) {
				password=Password.doHashing(password);
				if(Query.changePassword(email, password)) {
					out.print("Changed Successfully");
				}
				else {
					out.print("Something went wrong try again");
				}
			}
			else {
				out.print("Invalid Email or Passowrd");
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		
	}


}
