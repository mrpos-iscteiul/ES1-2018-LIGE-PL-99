package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.java.Email.SeeEmails;
import main.java.Email.SeeEmails.Email;
import main.java.Twitter.Twittermain.Tweet;
import twitter4j.TwitterException;

public class EmailGUI {

	private JFrame frame;
	DefaultListModel<Email> ecra = new DefaultListModel();
	JList<Email> lista = new JList<Email>(ecra);
	JScrollPane scroll = new JScrollPane(lista);	
	SeeEmails se = new SeeEmails();
	SendMailGUI smg;
	int mails=0;
	private String user;


	public EmailGUI(String user) {
		this.user=user;
	}

	public String getXMLuser() throws SAXException, IOException, ParserConfigurationException {

		String mail=null;

		Boolean logged = false;
		File fXmlFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);	
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("Service");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);


			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				if(eElement.getAttribute("Account").equals(user)) {
					mail=eElement.getAttribute("mail");
				}


			}

		}

		return mail;
	}

	public String getXMLpass() throws SAXException, IOException, ParserConfigurationException {

		String pass=null;

		Boolean logged = false;
		File fXmlFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);	
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("Service");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				if(eElement.getAttribute("Account").equals(user)) {
					pass=eElement.getAttribute("Mailpassword");
				}	
			}	
		}
		return pass;
	}

	public void start() throws MessagingException, IOException, SAXException, ParserConfigurationException {

		se.check("pop.gmail.com", "pop3", getXMLuser(), getXMLpass());
		System.out.println(getXMLuser());
		
		for (Email m : se.getMs()) {	
			ecra.addElement(m);
		} 
		lista.setModel(ecra);
		//se.close();
	}

	private void addFrameContent() {

		JPanel pesquisa=new JPanel();
		JPanel timeline=new JPanel();
		JPanel esquerda=new JPanel();
		JPanel corpo= new JPanel();

		timeline.setLayout(new GridLayout(1,2)); 	
		esquerda.setLayout(new GridLayout(2, 1));


		JButton compor=new JButton("Compor");
		final JTextField text = new JTextField();		
		final JTextArea txt=new JTextArea();
		JButton button = new JButton("Search");	

		text.setText("procurar");
		txt.setLineWrap(true);
		JScrollPane scrollArea = new JScrollPane(txt);

		corpo.add(scrollArea);
		esquerda.add(scroll);
		esquerda.add(compor);
		timeline.add(esquerda);
		timeline.add(corpo);
		pesquisa.add(text);	
		pesquisa.add(button);

		lista.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {	
				if(e.getValueIsAdjusting()) {	
					txt.setText(lista.getSelectedValue().text());
				}
			}

		});

		compor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					smg = new SendMailGUI(getXMLuser(), getXMLpass());
				} catch (SAXException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					e1.printStackTrace();
				}
				smg.init();

			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				txt.setText(null);
				ecra.clear();
				String filtro = text.getText();
				for(Email m : se.getMs()) {
					if(m.toString().contains(filtro)) {
						ecra.addElement(m);
					}
				}
				lista.setModel(ecra);
			}	
		});


		frame= new JFrame("Mail");
		frame.add(pesquisa,BorderLayout.NORTH);
		frame.add(timeline,BorderLayout.CENTER);		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocation(400,100);	
		frame.setVisible(true);
	}

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				addFrameContent();
			}
		});
	}


	public static void main(String[] args) throws MessagingException, IOException, SAXException, ParserConfigurationException {
				EmailGUI eg = new EmailGUI("dmbjs");
				eg.start();
				eg.init();

	}

}
