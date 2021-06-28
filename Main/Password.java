package Main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Password {

	
	public static void changePassword() {
		
	}
	
	public static String doHashing(String s) throws NoSuchAlgorithmException {
	      MessageDigest ms = MessageDigest.getInstance("SHA-224");
	      ms.update(s.getBytes());
	      byte[] result=ms.digest();
	      StringBuilder sb =new StringBuilder();

	      for(byte b:result){
	          sb.append(String.format("%02x",b));
	          
	      }
	      return sb.toString();
	  }

}
