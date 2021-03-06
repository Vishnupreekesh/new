package Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sqldatabase.Query;

public class Connector {
	
	public static User signin(String email) throws ClassNotFoundException, SQLException {
		
		String firstname;
		String lastname;
		int status;
		String password;
		String email1;
		int emailtype;
		ResultSet rs=Query.signinQuery(email);
        
		User user=null;
		int flag=0;
		while(rs.next()) {
			if(user==null) user=new User();
			firstname=user.setFirstname(rs.getString(1));
			lastname=user.setLastname(rs.getString(2));
			status=user.setStatus(Integer.parseInt(rs.getString(3)));
			password=user.setPassword(rs.getString(4));
			emailtype=user.setEmailtype(rs.getInt(5));
			email1=user.setEmail(rs.getString(6));	
		}
        return user;
		
	}
	
}
