package filter;

import javax.servlet.*;
import javax.servlet.http.*;  
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
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session =req.getSession();
	
		boolean loggedIn = session != null && session.getAttribute("name") != null;
			 
		if (loggedIn || req.getRequestURI().endsWith("Signin") ) {
			chain.doFilter(request, response);
		}
		else {
			req.getRequestDispatcher("/Signin.html").forward(request, response);
		}
		
	}

}
