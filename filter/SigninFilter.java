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
import java.util.HashMap;
import java.util.Map;  


public class SigninFilter implements Filter {
	
	private static final int Integer = 0;
	public static HashMap<String,Object> map=new HashMap<String,Object>();
	
	
	public void init(FilterConfig fConfig) throws ServletException {
        
    }

    
	public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {
		System.out.print("In Filter");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		HttpSession session =req.getSession();
		String id=(String)session.getAttribute("id");
		User obj=(User) session.getAttribute("Object");
		System.out.print(id);
		map.put(id,obj);
		if(id!=null) request.setAttribute(id, obj);
		boolean loggedIn = session != null && session.getAttribute("Object") != null;
//		boolean logg=req.getRequestURI().endsWith("Signin")||req.getRequestURI().endsWith("Logout.jsp"); 
		if (loggedIn) {
			chain.doFilter(request, response);
		}
		else {
			req.getRequestDispatcher("/Signin.html").forward(request, response);
		}
		
	}

}
