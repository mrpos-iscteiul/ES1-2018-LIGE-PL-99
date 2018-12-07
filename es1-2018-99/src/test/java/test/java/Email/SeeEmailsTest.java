package test.java.Email;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import main.java.Email.SeeEmails;
import main.java.GUI.EmailGUI;

public class SeeEmailsTest {
	EmailGUI eg = new EmailGUI("dmbjs");

	@Test
	public void testCheck() throws MessagingException, IOException, SAXException, ParserConfigurationException {
		eg.start();
		eg.init();
		assertFalse(eg.getPost().isEmpty());
	     
	}

}
