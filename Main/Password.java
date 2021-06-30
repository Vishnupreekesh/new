package Main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Password {

	
	public static boolean validatePassword(String password) {
		
		if(password.isEmpty()) return false;
		
		if(password.length()>7){
            boolean hasDigit=false,hasCapital=false,hasSmall=false,hasSpecial=false;
            for(int i=0;i<password.length();i++) {
                char c = password.charAt(i);
                if (Character.isDigit(c)) hasDigit = true;
                else if (Character.isLowerCase(c)) hasSmall = true;
                else if (Character.isUpperCase(c)) hasCapital = true;
                else hasSpecial = true;
            }
            if(hasDigit==true&&hasCapital==true&&hasSmall==true&&hasSpecial==true) return true;
            else return false;
        }
        return false;
		
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
