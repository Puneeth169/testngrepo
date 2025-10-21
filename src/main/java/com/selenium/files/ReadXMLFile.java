package com.selenium.files;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("flight.xml");
		Element ele = doc.getDocumentElement();
		System.out.println(ele.getTagName());
		NodeList list = ele.getChildNodes();
		int count=0;
		for(int i=0;i<list.getLength();i++) {
			Node item = list.item(i);
			if(item.getNodeType()==Node.ELEMENT_NODE) {
//				count++;
				NodeList innerlist = item.getChildNodes();
				for(int j=0;j<innerlist.getLength();j++) {
					Node item2 = innerlist.item(j);
					if(item2.getNodeType()==Node.ELEMENT_NODE) {
						count++;
						Element e=(Element)item2;
						System.out.println(e.getTextContent());
					}
					
				}
			}
		}
		System.out.println("Count:"+count);
	}
}
