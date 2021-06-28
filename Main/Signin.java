package Main;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import sqldatabase.Query;

public class Signin {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Email : ");
		String email=sc.next();
		System.out.println("Enter the Password : ");
		String pass=Password.doHashing(sc.next());
		
		User obj=Connector.signin(email);
		System.out.println(obj);
		if(obj.getEmail().isEmpty()) {
			System.out.print("Invalid Username");
		}
		else {
			if(pass.equals(obj.getPassword())){
				System.out.print("Login Successfully");
			}
			else {
				System.out.print("Invalid Password");
			}
		}
		
	}
	
	
}
