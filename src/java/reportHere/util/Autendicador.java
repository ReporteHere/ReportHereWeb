package reportHere.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autendicador extends Authenticator {
	private String user;
	private String password;
	private static Autendicador instance = null;

	private Autendicador() {
	}
   
	static public Autendicador getInstance() {
		if (instance == null) {
			instance = new Autendicador();
		}
		return instance;
	} 
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
	   
	   

