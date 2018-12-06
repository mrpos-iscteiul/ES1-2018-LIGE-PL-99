package main.java.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.java.xml.XmlProject;
import java.awt.BorderLayout;

public class interface_si extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private String user;
	private interface_apl apl;
	private String pass;
	XmlProject xml = new XmlProject();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interface_si frame = new interface_si();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public interface_si(String user, String pass) {
		this.user=user;
		this.pass=pass;
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		
	}
	
	

	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFrameC();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	



	public void addFrameC() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(529, 24, 158, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(529, 98, 158, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(529, 165, 158, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(529, 307, 158, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(529, 369, 158, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(529, 430, 158, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblFacebookAccessToken = new JLabel("Facebook Access token");
		lblFacebookAccessToken.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFacebookAccessToken.setBounds(316, 26, 201, 16);
		contentPane.add(lblFacebookAccessToken);
		
		JLabel lblTwitterAccessToken = new JLabel("Twitter Access token");
		lblTwitterAccessToken.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTwitterAccessToken.setBounds(315, 100, 202, 16);
		contentPane.add(lblTwitterAccessToken);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(316, 168, 201, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(316, 243, 201, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("ConsumerKey");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(316, 309, 201, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblConsumersecret = new JLabel("ConsumerSecret");
		lblConsumersecret.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumersecret.setBounds(316, 371, 201, 16);
		contentPane.add(lblConsumersecret);
		
		JLabel lblConsumertoken = new JLabel("ConsumerToken");
		lblConsumertoken.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumertoken.setBounds(316, 432, 201, 16);
		contentPane.add(lblConsumertoken);
		
		textField_7 = new JTextField();
		textField_7.setBounds(529, 486, 158, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblConsumertokensecret = new JLabel("ConsumerTokenSecret");
		lblConsumertokensecret.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumertokensecret.setBounds(316, 488, 201, 16);
		contentPane.add(lblConsumertokensecret);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 304, 574);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(interface_si2.class.getResource("/main/java/GUI/1413073433_images-2-.jpg")));
		label.setBounds(84, 200, 128, 128);
		panel.add(label);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setBounds(447, 531, 97, 25);
		contentPane.add(btnSignIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(529, 241, 158, 22);
		contentPane.add(passwordField);

		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String m = textField_2.getText();
				String p = passwordField.getText();
				String f = textField.getText();
				String t1 = textField_1.getText();
				try {
					xml.newEl(user, "smtp", pass, m, p,f,t1);
				} catch (Exception e1) {			
				}
				
				apl=new interface_apl(user);
				apl.init();
			}
		});

		

	}
	

	}


