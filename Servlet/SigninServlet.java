package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Main.Connector;
import Main.Password;
import Main.User;



@WebServlet("/Signin")
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
					out.print("Login Successfully");
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
