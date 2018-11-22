package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;

public class interface_apl extends JFrame {

	SeeEmails se=new SeeEmails();
	Twittermain t = new Twittermain();
	Fmain f = new Fmain();
	DefaultListModel<String> ecra = new DefaultListModel();
	JList<String> feed = new JList<String>(ecra);
	JScrollPane scroll = new JScrollPane(feed);	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interface_apl frame = new interface_apl();
					frame.setVisible(true);
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
	public interface_apl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());




		JPanel panel = new JPanel();
		//		panel.setBounds(0, 92, 458, 289);
		panel.setLayout(new GridLayout(3, 1));

		JCheckBox chckbxFacebook = new JCheckBox("Facebook");
		chckbxFacebook.setBounds(462, 112, 103, 25);
		final JCheckBox chckbxTwitter = new JCheckBox("Twitter");
		chckbxTwitter.setBounds(466, 170, 99, 25);
		JCheckBox chckbxEmail = new JCheckBox("email");
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
					try {
						t.timeline();
					} catch (TwitterException e1) {
						e1.printStackTrace();
					}
					
					for (Tweet s : (ArrayList<Tweet>) t.getList()) {
						String n = "Tweet ---> "+s;
						ecra.addElement(n);
					}
					feed.setModel(ecra);
				}
			}

			
		});



		contentPane.add(timeline, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.WEST);
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
