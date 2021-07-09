package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Main.Connector;
import Main.Password;
import Main.User;
import sqldatabase.Query;

public class SignupServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			PrintWriter out=response.getWriter();

			if(Connector.userAvailable(email)) {
				out.print("Email Already Available");
			}
			else {
				if(Password.validatePassword(password)) {
					password=Password.doHashing(password);
					if(Query.createuser(firstname, lastname, email, password)) {
						User obj=Connector.signin(email);
						
						HttpSession session=request.getSession();  
				        session.setAttribute("name",obj.getFirstname()); 
				        RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/Files/Home.jsp");
			            reqDisp.forward(request, response);
						
					}
					else out.print("Something went wrong try again");
				}
				else {
					out.print("Invalid Password");
				}
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		
	}



}
