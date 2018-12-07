package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.restfb.types.Post;

import main.java.Email.SeeEmails;
import main.java.Facebook.Fmain;
import main.java.Twitter.Twittermain;
import main.java.Twitter.Twittermain.Tweet;
import twitter4j.TwitterException;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class interface_apl extends JFrame {

	JFrame frame;
	SeeEmails se;
	TwitterGUI t;
	
	DefaultListModel<String> ecra = new DefaultListModel();
	JList<String> feed = new JList<String>(ecra);
	JScrollPane scroll = new JScrollPane(feed);	
	int mails=0;
	String user;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 
	 * 
	 */
	
	public interface_apl(String user) {
		this.user=user;
	}
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addFrameC();
				} catch (Exception e) {
					e.printStackTrace();
					//////////////
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void addFrameC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		//		panel.setBounds(0, 92, 458, 289);
		panel.setLayout(new GridLayout(1,3));
		final JCheckBox chckbxFacebook = new JCheckBox("Facebook");
		chckbxFacebook.setBounds(462, 112, 103, 25);
		final JCheckBox chckbxTwitter = new JCheckBox("Twitter");
		chckbxTwitter.setBounds(466, 170, 99, 25);
		final JCheckBox chckbxEmail = new JCheckBox("email");
		chckbxEmail.setBounds(466, 231, 113, 25);

		panel.add(chckbxFacebook);
		panel.add(chckbxTwitter);
		panel.add(chckbxEmail);

		JPanel timeline = new JPanel();
		timeline.add(scroll);
		JTextArea texto = new JTextArea();

		chckbxTwitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxTwitter.isSelected()) {
					t= new TwitterGUI(user);
					t.start();
					t.init();
				}
			}
		});

		chckbxEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxEmail.isSelected()) {
					EmailGUI eg = new EmailGUI(user);
					try {
						eg.start();
					} catch (MessagingException e1) {
					//S
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SAXException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					eg.init();									
				}

				feed.setModel(ecra);
			}

		});

		chckbxFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxFacebook.isSelected()) {
					facebook_GUI fg = new facebook_GUI(user);
					fg.start();
					fg.init();
				}
			}
		});
		
		contentPane.add(panel, BorderLayout.CENTER);
		frame= new JFrame();
		frame.add(contentPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(270,160);
		frame.setLocation(400,100);	
		frame.setVisible(true);

		//		JLabel lblNewLabel = new JLabel("New label");
		//		lblNewLabel.setBounds(12, 13, 446, 40);
		//		panel.add(lblNewLabel);
		//		
		//		JLabel label = new JLabel("New label");
		//		label.setBounds(12, 68, 446, 40);
		//		panel.add(label);
		//		
		//		JLabel label_1 = new JLabel("New label");
		//		label_1.setBounds(12, 127, 446, 40);
		//		panel.add(label_1);
		//		
		//		JLabel label_2 = new JLabel("New label");
		//		label_2.setBounds(12, 187, 446, 40);
		//		panel.add(label_2);
	}


}
