package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Main.Connector;
import Main.User;

public class HomeServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
	}
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	HttpSession session=request.getSession();  
	RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/Files/Home.jsp");
    reqDisp.forward(request, response);
    
	}
		
}
