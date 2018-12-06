package main.java.Email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;

public class SeeEmails {


	Message[] messages;
	static String host = "pop.gmail.com";// change accordingly
	static String mailStoreType = "pop3";
	static String username = "diogombj@gmail.com";// change accordingly
	static String password = "sednavuj";// change accordingly
	Store store;
	Folder emailFolder;
	ArrayList<Email> mails =  new ArrayList<Email>();

	public ArrayList<Email> getMs() {
		return mails;
	}
	public void close() throws MessagingException {
		emailFolder.close(false);
		store.close();
	}

	public class Email{
		String from;
		String sub;
		String text;

		public Email(String from, String sub, String text) {
			this.from=from;
			this.sub=sub;
			this.text=text;
		}
		public String toString() {
			return sub+"  "+from;
		}

		public String text() {
			return this.text;
		}

		
	}
	
	private String getTextFromMessage(Message message) throws IOException, MessagingException {
	    String result = "";
	    if (message.isMimeType("text/plain")) {
	        result = message.getContent().toString();
	    } else if (message.isMimeType("multipart/*")) {
	        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
	        result = getTextFromMimeMultipart(mimeMultipart);
	    }
	    return result;
	}

	private String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart) throws IOException, MessagingException {

	    int count = mimeMultipart.getCount();
	    if (count == 0)
	        throw new MessagingException("Multipart with no body parts not supported.");
	    boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
	    if (multipartAlt)
	        // alternatives appear in an order of increasing 
	        // faithfulness to the original content. Customize as req'd.
	        return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
	    String result = "";
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        result += getTextFromBodyPart(bodyPart);
	    }
	    return result;
	}

	private String getTextFromBodyPart(
	        BodyPart bodyPart) throws IOException, MessagingException {

	    String result = "";
	    if (bodyPart.isMimeType("text/plain")) {
	        result = (String) bodyPart.getContent();
	    } else if (bodyPart.isMimeType("text/html")) {
	        String html = (String) bodyPart.getContent();
	        result = org.jsoup.Jsoup.parse(html).text();
	    } else if (bodyPart.getContent() instanceof MimeMultipart){
	        result = getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	    }
	    return result;
	}


	public void check(String host, String storeType, String user, String password) {
		try {
			System.out.println(password);

			//create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			//create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");
			System.out.println("store");

			store.connect(host, user, password);
			System.out.println("conncet");

			//create the folder object and open it
			emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());

				String subj = "Subject: "+message.getSubject();
				String from = "From:  "+message.getFrom();
				String text = "Text:  "+ getTextFromMessage(messages[i]);
				Email e = new Email (from, subj, text);
				mails.add(e);
			}





		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SeeEmails se = new SeeEmails();
		se.check(host, mailStoreType, username, password);

	}
	//   

}
