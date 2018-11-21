package test.java.Email;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Email.SeeEmails;

public class SeeEmailsTest {
	SeeEmails se = new SeeEmails();

	@Test
	public void testCheck() {
		
	      String host = "pop.gmail.com";// change accordingly
	      String mailStoreType = "pop3";
	      String username = "diogombj@gmail.com";// change accordingly
	      String password = "sednavuj";// change accordingly
	      se.check(host, mailStoreType, username, password);
	      
	      assertTrue(se.getMs().length!=0);
	}

}
