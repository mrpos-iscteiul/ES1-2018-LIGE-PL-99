package main.java.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class XmlProject{

	File inputFile = new File("config.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder;
	Document doc;

	public void newEl(String user, String protocol, String pass, String mail, String mailpass, String fbtoken, String t1, String t2, String t3, String t4) throws ParserConfigurationException, SAXException, IOException {


		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			System.out.println("\n----- Search the XML document with xpath queries -----");  
			// Query 1 
			System.out.println("Query 1: ");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("/XML/Service/@*");
			NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.print(nl.item(i).getNodeName()  + ": ");
				System.out.println(nl.item(i).getFirstChild().getNodeValue());
			}
			// Query 2
			System.out.println("\nQuery 2: ");         
			expr = xpath.compile("/XML/Paths/docPath");
			String str = (String) expr.evaluate(doc, XPathConstants.STRING);

			System.out.println("docPath: " + str);

			// Adding new element Service with attributes to the XML document (root node)
			System.out.println("\n----- Adding new element <Service> with attributes to the XML document -----");

			Element newElement1 = doc.createElement("Service");
			newElement1.setAttribute("Protocol", protocol);
			newElement1.setAttribute("Account", user);
			newElement1.setAttribute("Password", pass);
			newElement1.setAttribute("mail", mail);
			newElement1.setAttribute("Mailpassword", mailpass);
			newElement1.setAttribute("fbtoken", fbtoken);
			newElement1.setAttribute("t1", t1);
			newElement1.setAttribute("t2", t2);
			newElement1.setAttribute("t3", t3);
			newElement1.setAttribute("t4", t4);

			Node n = doc.getDocumentElement();
			n.appendChild(newElement1);


			// Adding new element OtherNewTag to the XML document (root node)
			System.out.println("----- Adding new element <OtherNewTag> to the XML document -----");



			// Save XML document
			System.out.println("\nSave XML document.");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
		} catch (XPathExpressionException e) {

			e.printStackTrace();
		} catch (DOMException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {

			e.printStackTrace();
		} catch (TransformerException e) {

			e.printStackTrace();
		}



	}



	public static void main(String[] args){

	}
}