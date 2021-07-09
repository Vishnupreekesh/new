package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Profile extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		System.out.print("In Profile");
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/Files/Profile.jsp");
        reqDisp.forward(request, response);
//		response.sendRedirect("Files/Profile.jsp");
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		
	}


}
