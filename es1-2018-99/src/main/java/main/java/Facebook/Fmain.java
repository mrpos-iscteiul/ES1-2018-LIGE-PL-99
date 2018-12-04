package main.java.Facebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;

import main.java.GUI.interface_apl;

public class Fmain {

	int countP=0;
	private ArrayList<Post> posts = new ArrayList<Post>();
	private String user;

	public Fmain(String user) {
		this.user=user;
	}

	public int getC() {
		return countP;
	}

	public ArrayList getP() {
		return posts;
	}

	public void feed() throws SAXException, IOException, ParserConfigurationException {

		
		//String accessToken="EAACnyXeKEEkBAEBd0pqQAT19f7emVmZCWh8ejRce7YUcY57pFOFux3FTZB93qJgHz9wsA5WW6X4ZCQsm0ivq36QQIAYaoChBsFi7z6ZBANr2fVZC75QZCwEL4WWPWskUQoZBcUpYRSRZCCuzqWmprZB9XaZBYOW4ZAPgIE8S6H88EygRwZDZD";
		String accessToken=readfbtoken();
		FacebookClient fbclient = new DefaultFacebookClient(accessToken);
		User me = fbclient.fetchObject("me", User.class);

		Connection<Post> result = fbclient.fetchConnection("me/feed", Post.class);

		for(List<Post> page : result) {
			for(Post aPost : page){
				posts.add(aPost);
				System.out.println(aPost.getMessage());
				System.out.println("Id: "+"fb.com/"+aPost.getId());
				countP++;
			}

		}
		System.out.println("Nº de resultados: " + countP);
	}


	public String readfbtoken() throws SAXException, IOException, ParserConfigurationException {
		String fbtoken=null;
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
					fbtoken=eElement.getAttribute("fbtoken");
				}


			}

		}

		return fbtoken;

	}
		//	public static void main(String[] args) {
		//		Fmain fm = new Fmain();
		//		fm.feed();
		//		
		//		/**
		//		 * Acesso ao utilizador
		//		 */
		//		
		//		
		//		
		//		/**
		//		 * Acesso e impressão do feed do utilizador e nr de resultados
		//		 */
		//		
		//		
		//
		//	
		//		
		//
		//	}
	
	}