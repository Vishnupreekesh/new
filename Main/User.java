package Main;

import java.util.ArrayList;

public class User {

	String firstname;
	String lastname;
	String email;
	int status;
	int emailtype;
	String password;
	ArrayList<String> emailList=new ArrayList<String>();
	ArrayList<Integer> emailtypeList=new ArrayList<Integer>();
	
	
	public String getFirstname() {
		return firstname;
	}

	public String setFirstname(String firstname) {
		return this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String setLastname(String lastname) {
		return this.lastname = lastname;
	}
	
	
	public int getStatus() {
		return status;
	}

	public int setStatus(int status) {
		return this.status = status;
	}

	public ArrayList<Integer> getEmailtype() {
		return emailtypeList;
	}

	public int setEmailtype(int emailtype) {
		int n=this.emailtype = emailtype;
		emailtypeList.add(n);
		return n;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public ArrayList getEmail() {
		return emailList;
	}

	public String setEmail(String email) {
		String e=this.email = email;
		emailList.add(e);
		return e;
	}
	
	public String getName() {
		return firstname+" "+lastname;
	}

	
	
	public ArrayList getEmailObject() {
		return emailList;
	}
	
	public String toString() {
		return firstname+" "+lastname+" "+password+" "+emailList+" "+emailtypeList;
	}

	

}
