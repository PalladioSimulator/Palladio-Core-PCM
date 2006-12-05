/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Ihssane
 * 
 */
public class ChartConfigurationHandler extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println( "Start von characters" );
	    // Ausgabe der Zeichenkette
	    System.out.println( "Zeichenkette: " );
	    for ( int i = start; i < (start + length); i++ )
	      System.out.print( "." + ch[i] );
	    System.out.println();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println( "Ende des Dokuments" );
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println( "Ende eines Elements" );
		  // Namensraumadresse ausgeben
		  System.out.println( "namespaceURI: " + uri );
		  // lokalen Namen ausgeben
		  System.out.println( "localName: " + localName );
		  // qualifizierenden Namen ausgeben
		  System.out.println( "qName: " + qName );
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Document started");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("Start eines Elements");
		// Namensraumadresse ausgeben
		System.out.println("namespaceURI: " + uri);
		// lokalen Namen ausgeben
		System.out.println("localName: " + localName);
		// qualifizierenden Namen ausgeben
		System.out.println("qName: " + qName);
		// Attribute ausgeben
		for (int i = 0; i < atts.getLength(); i++)
			System.out.println("Attribut Nr. " + i + ": " + atts.getQName(i)
					+ " = " + atts.getValue(i));
	}

}
