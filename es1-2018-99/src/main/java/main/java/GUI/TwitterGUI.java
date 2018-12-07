package main.java.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.java.Twitter.Twittermain;
import main.java.Twitter.Twittermain.Tweet;
import main.java.xml.XmlProject;
import twitter4j.TwitterException;

public class TwitterGUI {

	private JFrame frame;
	DefaultListModel<Tweet> ecra = new DefaultListModel();
	JList<Tweet> feed = new JList<Tweet>(ecra);
	JScrollPane scroll = new JScrollPane(feed);	
	Twittermain t = new Twittermain();
	ArrayList<Tweet> selecionado = new ArrayList<Tweet>();
	XmlProject xml = new XmlProject();
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String name;
	
	public DefaultListModel<Tweet> getEcra(){
		return ecra;
	}
	
	public void start() {
		try {
			readTokens(name);
			t.timeline(t1,t2,t3,t4);
		} catch (TwitterException e1) {
			e1.printStackTrace();
		}

		for (Tweet s : (ArrayList<Tweet>) t.getList()) {
			ecra.addElement(s);
		}
		feed.setModel(ecra);
	}

	private void addFrameContent() {

		JPanel pesquisa=new JPanel();
		JPanel timeline=new JPanel();
		JPanel tweet= new JPanel();
		JPanel accoes=new JPanel();

		timeline.setLayout(new GridLayout(1,2)); 	
		tweet.setLayout(new GridLayout(2,1));
		accoes.setLayout(new GridLayout(1,2));

		JButton like=new JButton("Like");
		JButton rt=new JButton("RT");
		final JTextField text = new JTextField();		
		final JTextArea txt=new JTextArea();
		JButton button = new JButton("Search");	

		text.setText("procurar");
		txt.setLineWrap(true);
		JScrollPane scrollArea = new JScrollPane(txt);
		accoes.add(like);
		accoes.add(rt);
		tweet.add(scrollArea);
		tweet.add(accoes);
		timeline.add(scroll);
		timeline.add(tweet);
		pesquisa.add(text);	
		pesquisa.add(button);

		feed.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {	
				if(e.getValueIsAdjusting()) {	
					selecionado.clear();
					txt.setText(feed.getSelectedValue().toString());
					selecionado.add(feed.getSelectedValue());
				}
			}

		});

		like.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Tweet tw = selecionado.get(0);
				long id = tw.getId();
				try {
					t.like(id);
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}

			}
		});

		rt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Tweet tw = selecionado.get(0);
				long id = tw.getId();
				try {
					t.retweeet(id);;
				} catch (TwitterException e1) {
					e1.printStackTrace();
				}

			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				txt.setText(null);
				ecra.clear();
				String filtro = text.getText();
				for (Tweet s : (ArrayList<Tweet>) t.getList()) {
					if(s.toString().contains(filtro))
						ecra.addElement(s);
				}
				feed.setModel(ecra);
			}
		});

		frame= new JFrame("Twitter");
		frame.add(pesquisa,BorderLayout.NORTH);
		frame.add(timeline,BorderLayout.CENTER);		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocation(400,100);	
		frame.setVisible(true);
	}

	public void init() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				addFrameContent();
			}
		});
	}
	
	public TwitterGUI (String name) {
		this.name=name;
	}

//	public static void main(String[] args) {
//		TwitterGUI tg = new TwitterGUI(name,pass);	
//		tg.start();
//		tg.init();

//	}
	
	public void readTokens(String name) {
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
					if(eElement.getAttribute("Account").equals(name)) {
						t1 = eElement.getAttribute("t1");
						t2 = eElement.getAttribute("t2");
						t3 = eElement.getAttribute("t3");
						t4 = eElement.getAttribute("t4");
					}


				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
