package transformation.util;

import java.io.*;
import java.util.*;

/**
 * reads properties from a file with the syntax:
 * # comment
 * name = value
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 */
public class PropertiesReader {
	/**
	 * input file
	 */
	private String filename;

	/**
	 * don't forget to set the reference to a PropertiesReader to "null"
	 * if it is not garbage collected
	 */
	private FileInputStream fileReader;

	/**
	 * only this constructor sets the InputStream
	 * @param filename name of the properties-file
	 */
	public PropertiesReader(String filename) {
		this.filename = filename;
		File file = new File(filename);
		if (!file.exists())
			try {
				file.createNewFile();
			} catch ( IOException e ) {
				System.err.println("Can't create file " + filename + ".");
			}
			try {
				fileReader = new FileInputStream(filename); 
			} catch ( FileNotFoundException e ) {
				System.err.println("Can't find file " + filename + ".");
			}
	}

	/**
	 * @param p Properties with or without (p==null) content
	 * @return p + Properties from file
	 */
	public Properties readProperties(Properties p) {
		try {
			if (p==null) p = new Properties();
			p.load(fileReader);
		} catch ( IOException e ) {
			System.err.println("Can't read from file " + filename + ".");
		}
		return p;
	}
}