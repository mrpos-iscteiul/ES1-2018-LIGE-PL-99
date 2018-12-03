package main.java.GUI;

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

import main.java.xml.XmlProject;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InterfaceGrafica extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField password;
	private interface_apl apl;
	XmlProject xml = new XmlProject();

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica frame = new InterfaceGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 336);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(173, 0, 338, 289);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(147, 87, 147, 26);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(53, 90, 82, 26);
		panel.add(lblNewLabel);
		///////////////////////
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 160, 88, 26);
		panel.add(lblNewLabel_1);




		password = new JPasswordField();
		password.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

			}
		});
		password.setBounds(147, 160, 147, 26);
		panel.add(password);

		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String pass = password.getText();
			//	try {
			//		xml.newEl(user, "smtp", pass);
			//	} catch (Exception e1) {			
			//	}
				
				readXML(user, pass);
				

			}
		});

		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBounds(117, 223, 97, 25);
		panel.add(btnNewButton);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("1413073433_images-2-.jpg")));
		lblNewLabel_2.setLabelFor(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 83, 136, 134);
		contentPane.add(lblNewLabel_2);
	}
	
	public void readXML(String name, String pass) {
		try {
			Boolean logged = false;
			File fXmlFile = new File("config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
					
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Service");
					
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
						
						
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if(eElement.getAttribute("Account").equals(name) && eElement.getAttribute("Password").equals(pass)) {
						apl = new interface_apl();
						apl.setVisible(true);
						logged=true;
						setVisible(false);
					}
					
						
				}
				
			}
			if (logged==false)
				failedLogIn();
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
	
	public void failedLogIn() {
		final JPanel panel = new JPanel();

	    JOptionPane.showMessageDialog(panel, "Unvalid User or Password", "Warning",
	    		JOptionPane.WARNING_MESSAGE);
	}

	
}

