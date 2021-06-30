package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Main.Connector;
import Main.Password;
import Main.User;

public class SigninServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			String pass=Password.doHashing(password);
			User obj=Connector.signin(email);
			PrintWriter out=respond.getWriter();
			if(obj==null) {
				out.print("Invalid Username");
			}
			else {
				if(pass.equals(obj.getPassword())){
					Cookie cookie=new Cookie("email",email);
					cookie.setMaxAge(365*60*60*24);
					respond.addCookie(cookie);
					request.setAttribute("User",obj);
					request.getRequestDispatcher("Home.jsp").forward(request, respond);
				}
				else {
					out.print("Invalid Password");
				}
			}
				
					
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse respond) throws IOException, ServletException {
		
	}


}
