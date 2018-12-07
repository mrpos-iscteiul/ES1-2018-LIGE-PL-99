package test.java.Email;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Email.EmailSend;

public class EmailSendTest {
	
	EmailSend es= new EmailSend("dmbjuvandes@gmail.com", "ola", "adues", "diogombj@gmail.com", "sednavuj");
	
	@Test
	public void testSend() {
		es.send();
		assertFalse(es.getEnvios()==0);
	}

}
