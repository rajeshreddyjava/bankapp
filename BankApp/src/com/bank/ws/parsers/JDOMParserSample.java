package com.bank.ws;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPath;

public class JDOMParserSample {
	public static void main(String[] args)  {
		
		SAXBuilder builder = new SAXBuilder();
		
		try{
			
			
		Element rootElement = new Element("Raj");
		Document doc = new Document();
		doc.setRootElement(rootElement);
		Element bodyElement = new Element("body5");
		bodyElement.addContent((new Element("p")).setText("Testing"));
		doc.getRootElement().addContent(bodyElement);
		
		Document document = builder.build(new File("src/com/bank/xml/sample.xml"));
		
		System.out.println(document.getRootElement().getName());
		Element rootElement1 = document.getRootElement();
		XPath xpath =  XPath.newInstance("");
		List<Element> students = rootElement1.getChildren();
		for(Element element: students){
			System.out.println(element.getChild("firstName").getText());			
		}
		
		XMLOutputter outputter =  new XMLOutputter();
		outputter.setFormat(Format.getPrettyFormat());
		outputter.output(document, new FileWriter( new File("sample.txt")));
		outputter.output(doc, System.out);
		//Document doc = new Document();
		}
		catch(JDOMException je){
			je.printStackTrace();
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
	}

}
