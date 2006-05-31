package de.uka.ipd.sdq.simucom.config;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ConfigFileReaderFactory implements IConfig {
	
	private Document dom = null;

	public ConfigFileReaderFactory(String file) throws Exception
	{
		parseXmlFile(file);
	}
	
	public IConfig getConfig()
	{
		return this;
	}
	
	private void parseXmlFile(String file){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(file);
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public String getSimuComModelURI() {
		String result = dom.getElementsByTagName("SimuComModel").item(0).getTextContent();
		return result;
	}	
}
