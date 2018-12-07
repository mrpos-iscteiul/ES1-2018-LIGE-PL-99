package main.java.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.java.Email.EmailSend;

public class SendMailGUI {
	
	JFrame frame;
	String user;
	String passw;
	
	public SendMailGUI(String user, String passw) {
		this.user=user;
		this.passw=passw;
	}
	private void addFrameContent() {
		
		final JTextField destino = new JTextField("Destino");
		final JTextField assunto = new JTextField("Assunto");	
		final JTextField texto = new JTextField("texto");
		JButton send = new JButton("Send");
		JPanel cima = new JPanel();
		cima.setLayout(new GridLayout(1,2));
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(2,1));
		JPanel corpo = new JPanel();
		JPanel janela = new JPanel();
		janela.setLayout(new GridLayout(2,1));
		info.add(destino);
		info.add(assunto);	
		cima.add(info);
		cima.add(send);
		janela.add(cima);
		janela.add(texto);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String dest=destino.getText();
				String asst=assunto.getText();
				String txt=texto.getText();
				EmailSend mailsend= new EmailSend(dest, asst, txt, user, passw);
				mailsend.send();

			}
		});
		
	
		frame= new JFrame("Send Mail");
		frame.add(janela);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocation(400,100);	
		frame.setVisible(true);
		
	}
	
	void init() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				addFrameContent();
			}
		});
	}
	
	

}
