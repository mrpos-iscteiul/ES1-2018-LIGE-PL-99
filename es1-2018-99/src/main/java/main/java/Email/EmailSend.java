
package main.java.Email;


import java.security.Security;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class EmailSend {
	
	int envios=0;
	
	public int getEnvios() {
		return envios;
	}

	public  void send() {
		try{
			String host ="smtp.gmail.com" ;
			final String user = "diogombj@gmail.com";
			final String pass = "sednavuj";
			String to = "dmbjuvandes@gmail.com";
			String from = "diogombj@gmail.com";
			String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
			String messageText = "Your Is Test Email :";
			boolean sessionDebug = false;

			Properties props = System.getProperties();

			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			


			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, pass);
				}
			});
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject); msg.setSentDate(new Date());
			msg.setText(messageText);

			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
			envios++;
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String args[]){
		EmailSend es = new EmailSend();
		es.send();
		System.out.println(es.envios);
		System.out.println("");

	}
}
