package Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Main.Connector;
import Main.Password;
import Main.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;  


public class SigninFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
        
    }

    
	public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {
		System.out.print("In Filter");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session =req.getSession();
		
		String[] str= {"/Signup","/Signup.html","/ChangePassword.html","/ChangePassword","/signin.css","/Signin"};
		
		boolean loginRequest1=false;
		for(int i=0;i<str.length;i++) {
			String loginURI = req.getContextPath() +str[i];
			if(req.getRequestURI().equals(loginURI)) {
				loginRequest1 = true;
				break;
			}
		}
		
		System.out.print(loginRequest1);
		 boolean loggedIn = session != null && session.getAttribute("name") != null;
		 
		 String path= req.getRequestURI();
		 System.out.println(path);
		 
		if(loggedIn || loginRequest1 ) {
			
			chain.doFilter(request, response);
		}
		else {
			req.getRequestDispatcher("Signin.html").forward(request, response);
		}
		
	}

}
