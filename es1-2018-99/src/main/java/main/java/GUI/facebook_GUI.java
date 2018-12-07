package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JTextArea;

public class facebook_GUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private String fbtoken;
	private String user;
	DefaultListModel<Post> ecra = new DefaultListModel();
	JList<Post> feed = new JList<Post>(ecra);
	private Fmain f;
	
	
	public facebook_GUI(String user) {
		this.user=user;
		
		f = new Fmain(user);
	}
	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facebook_GUI frame = new facebook_GUI(user);
					addFrame();
					frame.setVisible(true);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Post s : (ArrayList<Post>) f.getP()) {
			ecra.addElement(s);
		}
		feed.setModel(ecra);
	}
	/**
	 * Create the frame.
	 */
	public void addFrame() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Facebook");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(228, 14, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(172, 16, 56, 16);
		panel.add(lblUser);
		//////
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 49, 544, 248);
		panel.add(textArea);
	}
	
	
}
