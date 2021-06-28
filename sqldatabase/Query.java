package sqldatabase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	
	public static ResultSet signinQuery(String email) throws ClassNotFoundException, SQLException {
		
		String query="select u.firstname,u.lastname,u.status,p.password,e.email_type,e.email from  (usertable u join emailtable e on u.userid=e.userid) join pwdtable p on u.userid=p.userid where e.userid=(select userid from emailtable where email='"+email+"') ";
		ResultSet r=SqlFunctions.select(query);
		return r;
		
	}
}
