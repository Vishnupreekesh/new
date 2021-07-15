package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session=request.getSession();  
        session.invalidate();  
		
		RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/Signin.html");
        reqDisp.forward(request, response);
		
	}
}
