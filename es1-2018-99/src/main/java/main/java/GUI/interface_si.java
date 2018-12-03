package main.java.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class interface_si extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	public static void main(String[] args) {
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
	}
	
	
	
	public interface_si() {
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

		JLabel lblNewLabel = new JLabel("Facebook Access Token");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setBounds(53, 90, 82, 26);
		panel.add(lblNewLabel);
		///////////////////////
		JLabel lblNewLabel_1 = new JLabel("Twitter Access Token");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 160, 88, 26);
		panel.add(lblNewLabel_1);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setForeground(Color.BLUE);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSignIn.setBounds(197, 223, 97, 25);
		panel.add(btnSignIn);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(InterfaceGrafica.class.getResource("1413073433_images-2-.jpg")));
		lblNewLabel_2.setLabelFor(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 83, 136, 134);
		contentPane.add(lblNewLabel_2);
	}
}
