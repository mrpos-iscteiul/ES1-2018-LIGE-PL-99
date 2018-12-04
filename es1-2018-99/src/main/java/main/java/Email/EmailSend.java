
package main.java.Email;


import java.security.Security;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class EmailSend {
	
	int envios=0;
	String destino;
	String assunto;
	String texto;
	String user;
	String password;
	
	public EmailSend(String des, String sub, String txt, String user, String pass){
		this.destino=des;
		this.assunto=sub;
		this.texto=txt;
		this.user=user;
		this.password=pass;
	}
	
	public int getEnvios() {
		return envios;
	}

	public  void send() {
		try{
			String host ="smtp.gmail.com" ;		
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
					return new PasswordAuthentication(user, password);
				}
			});
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(user));
			InternetAddress[] address = {new InternetAddress(destino)};
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(assunto); msg.setSentDate(new Date());
			msg.setText(texto);

			Transport transport=mailSession.getTransport("smtp");
			transport.connect(host, user, password);
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
//		EmailSend es = new EmailSend();
//		es.send();
//		System.out.println(es.envios);
//		System.out.println("");

	}
}
