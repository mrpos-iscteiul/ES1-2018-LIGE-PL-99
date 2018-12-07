package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.restfb.types.Post;

import main.java.Facebook.Fmain;
import main.java.Twitter.Twittermain.Tweet;
import twitter4j.TwitterException;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;

public class facebook_GUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private String fbtoken;
	private String user;
	DefaultListModel<String> ecra = new DefaultListModel();
	JList<String> feed = new JList<String>(ecra);
	JScrollPane scroll = new JScrollPane(feed);	
	private Fmain f;
	
	
	public facebook_GUI(String user) {
		this.user=user;
		
		f = new Fmain(user);
	}
	/**
	 * Launch the application.
	 */
	
	public DefaultListModel<String> getPost(){
		return ecra;
	}
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start() {
		try {
			f.feed();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		for (String s : (ArrayList<String>) f.getP()) {	
			ecra.addElement(s);
		}
		feed.setModel(ecra);
	}
	/**
	 * Create the frame.
	 */
	public void addFrame() {
		frame = new JFrame("Facebook");
		
		setBounds(100, 100, 572, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		

		contentPane.add(scroll);
		

		frame.add(contentPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocation(400,100);	
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		facebook_GUI fg = new facebook_GUI("789");
		fg.start();
		fg.init();
	}
	
	
}
