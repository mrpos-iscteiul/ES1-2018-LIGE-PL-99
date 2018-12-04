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

public class interface_si extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private String user;
	private interface_apl apl;


	public interface_si(String user) {
		this.user=user;
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
	public void writeXML(String mail, String passw) {
		try {
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
						System.out.println(user);
						eElement.setAttribute("mail", mail);
						System.out.println(mail);;
						eElement.setAttribute("Mailpassword", passw);
						System.out.println(passw);
						//						apl = new interface_apl(user);
						//						apl.setVisible(true);
						//						logged=true;
						//						setVisible(false);
					}


				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void addFrameC() {



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
		textField.setBounds(179, 30, 147, 26);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Facebook Access Token");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(12, 29, 167, 26);
		panel.add(lblNewLabel);
		///////////////////////
		JLabel lblNewLabel_1 = new JLabel("Twitter Access Token");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 93, 167, 26);
		panel.add(lblNewLabel_1);

		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setForeground(Color.BLUE);

		btnSignIn.setBounds(211, 251, 97, 25);
		panel.add(btnSignIn);

		textField_1 = new JTextField();
		textField_1.setBounds(179, 94, 147, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(179, 151, 147, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 154, 124, 21);
		panel.add(lblNewLabel_3);

		textField_3 = new JPasswordField();
		textField_3.setBounds(179, 212, 147, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);

		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String m = textField_2.getText();
				System.out.println("botao");
				String p = textField_3.getText();
				writeXML(m, p);
				apl=new interface_apl(user);
				apl.init();
			}
		});

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(12, 217, 97, 21);
		panel.add(lblPassword);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("1413073433_images-2-.jpg")));
		lblNewLabel_2.setLabelFor(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 83, 136, 134);
		contentPane.add(lblNewLabel_2);
		frame = new JFrame();
		frame.add(contentPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocation(400,100);	
		frame.setVisible(true);

	}
}
