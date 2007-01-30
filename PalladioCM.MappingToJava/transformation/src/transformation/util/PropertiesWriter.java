package transformation.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * writes properties to a file with the format:
 * # comment
 * name = value
 * 
 * @author <a href="mailto:Reiner.Schaudel@t-online.de" />Reiner Schaudel
 *
 */
public class PropertiesWriter {
	/**
	 * output file
	 */
	private String filename;
	private String header = "# + properties for ...";

	/**
	 * don't forget to set the reference to a PropertiesWriter to "null"
	 * if it is not garbage collected
	 */
	private FileOutputStream fileWriter;

	/**
	 * only this constructor sets the OutputStream
	 * @param filename name of the properties-file
	 */
	public PropertiesWriter(String filename) {
		this.filename = filename;
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch ( IOException e ) {
				System.err.println("Can't create file " + filename + ".");
			}
		}
		try {
			fileWriter = new FileOutputStream(filename); 
		} catch ( FileNotFoundException e ) {
			System.err.println("Can't find file " + filename + ".");
		}
	}
 
	/**
	 * @param text one line to describe the properties 
	 */
	public void setHeader(String text) {
		header = "# " + text;
	}
	
	/** 
	 * @param p Properties with content that are stored to file
	 */
	public void write(Properties p) {
		try {
			p.store(fileWriter, header);
		} catch ( IOException e ) {
			System.err.println("Can't write to file " + filename + ".");
		}
	}
}