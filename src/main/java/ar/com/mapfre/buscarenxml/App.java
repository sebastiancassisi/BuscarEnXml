package ar.com.mapfre.buscarenxml;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class App {

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
	
		Document doc = db.parse(new FileInputStream(new File("src\\main\\java\\ar\\com\\mapfre\\archivos\\in.xml")));
		
		XPathFactory factory = XPathFactory.newInstance();
		
		XPath xpath = factory.newXPath();
		
		String expression;
		NodeList nodeList;
		
		// 1. Todos los elementos con atributo 'key' igual a 'mykey1'
		expression = "//*[@key='mykey1']";
		nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		System.out.print("1. ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
		
		// 2. Todos los elementos con atributo 'key' igual a 'mykey'
		expression = "//*[contains(@key,'mykey')]";
		nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		System.out.print("1. ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
		
		// 3. todos los elementos que tienen el atributo de clave
		expression = "//*[@key]";
		nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		System.out.print("3. ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();

		// 4. all elements that have both key and attr attributes
		expression = "//*[@key and @attr]";
		nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		System.out.print("4. ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
		
		// 5. all entry elements that have the key attribute
		expression = "//entry[@key]";
		nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		System.out.print("5. ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.print(nodeList.item(i).getNodeName() + " ");
		}
		System.out.println();
		
	}

}
