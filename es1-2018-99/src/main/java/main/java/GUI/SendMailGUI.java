package main.java.GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SendMailGUI {
	
	JFrame frame;
	
	private void addFrameContent() {
		
		JTextField destino = new JTextField("Destino");
		JTextField assunto = new JTextField("Assunto");	
		JTextField texto = new JTextField("texto");
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(2,1));
		JPanel corpo = new JPanel();
		JPanel janela = new JPanel();
		janela.setLayout(new GridLayout(2,1));
		info.add(destino);
		info.add(assunto);
		
		janela.add(info);
		janela.add(texto);
	
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
	public static void main(String[] args) {
		SendMailGUI se = new SendMailGUI();
		se.init();

	}

}
