package Servlet;

import javax.servlet.*;
import Main.Connector;
import Main.Password;
import Main.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;  

public class SigninFilter implements Filter {
	
	private ServletContext context;
	public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    
	public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		 

		try {
			String pass=Password.doHashing(password);
			User obj=Connector.signin(email);
			PrintWriter out=response.getWriter();

			if(obj==null) {
				out.print("Invalid Username");
			}
			else {
				if(pass.equals(obj.getPassword())){
					chain.doFilter(request, response);
				
				}
				else {
					out.print("Invalid Password");
				}
			}
				
					
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			e.printStackTrace();
		}
	}

}
