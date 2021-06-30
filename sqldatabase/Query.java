package sqldatabase;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Query {
	
	public static boolean changePassword(String email,String password) throws ClassNotFoundException, SQLException {
		String query="update pwdtable p join emailtable e on p.userid=e.userid set p.password='"+password+"' where e.email='"+email+"' ";
	    int result=SqlFunctions.update(query);
	    if(result>0) return true;
	    else return false;
	}
	
	
	public static boolean createuser(String firstname,String lastname,String email,String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		String query="Select userid from usertable";
		ResultSet rs=SqlFunctions.select(query);
		int userid=0;
		while(rs.next()) userid=rs.getInt(1);
		userid++;
		
	    String query1="insert into usertable "+"(userid,firstname,lastname,status,created_time,modified_time) values "+"('"+userid+"','"+firstname+"','"+lastname+"','1','"+dtf.format(now)+"','"+dtf.format(now)+"')";
	    int result1=SqlFunctions.insert(query1);
	    
	    String query2="insert into emailtable "+"(userid,email,email_validation,email_Type,created_Time,modified_Time) values "+"('"+userid+"','"+email+"','"+'1'+"','1','"+dtf.format(now)+"','"+dtf.format(now)+"')";
	    int result2=SqlFunctions.insert(query2);
	    
	    String query3="insert into pwdtable "+"(userid,password,lastchange) values "+"('"+userid+"','"+password+"','"+dtf.format(now)+"')";
	    int result3=SqlFunctions.insert(query3);
	    
	    if(result1>0&&result2>0&&result3>0) return true;
	    else return false;
	}
	
	public static ResultSet signinQuery(String email) throws ClassNotFoundException, SQLException {
		
		String query="select u.firstname,u.lastname,u.status,p.password,e.email_type,e.email from  (usertable u join emailtable e on u.userid=e.userid) join pwdtable p on u.userid=p.userid where e.userid=(select userid from emailtable where email='"+email+"') ";
		ResultSet r=SqlFunctions.select(query);
		return r;
		
	}
	
	public static ResultSet isAvailable(String email)  throws ClassNotFoundException, SQLException {
		
		String query="Select userid from emailtable where email='"+email+"' ";
		ResultSet r=SqlFunctions.select(query);
		return r;
	}
}
