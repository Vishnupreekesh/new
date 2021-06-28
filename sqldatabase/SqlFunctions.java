package sqldatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlFunctions {
	
	public void create() {
		
	}
	 
	public void alter() {
		
	}
	public void delete() {
		
	}
	
	public static ResultSet select(String query) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/userdatabase","root","Vishnu21@");  
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		return rs;
	}

}
