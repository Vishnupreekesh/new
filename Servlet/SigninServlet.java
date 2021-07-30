package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

public class SigninServlet extends HttpServlet {
	public static HashMap<Date,String> map=new HashMap<Date,String>();
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
			User obj=Connector.signin(email);
			PrintWriter out=response.getWriter();

			if(obj==null) {
				out.print("Invalid Username");
			}
			else {
				String pass=Password.doHashing(password);
				if(pass.equals(obj.getPassword())){
					System.out.print(obj.getFirstname());
					HttpSession session=request.getSession();  
			        session.setAttribute("Object",obj);
			        String ssnId = session.getId();
			        session.setAttribute("id", ssnId);
			        
			        if(!session.isNew()){
			        	Date date=new Date(session.getLastAccessedTime());
						map.put(date, ssnId);
					}
			        else {
			        	Date date=new Date(session.getCreationTime());
			        	map.put(date, ssnId);
			        }
			        
			        session.setAttribute("session", map);
			        System.out.print("In signin Server");
					response.sendRedirect("Files/Home.jsp");
				
				}
				else {
					out.print("Invalid Password");
				}
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		
		String email=request.getParameter("email");
		System.out.print(email);
		if(email==null) {
			RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/Signin.html");
	        reqDisp.forward(request, respond);
	
		}
	}
	


}
