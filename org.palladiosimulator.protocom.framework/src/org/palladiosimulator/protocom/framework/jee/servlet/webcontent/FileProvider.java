package org.palladiosimulator.protocom.framework.jee.servlet.webcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Christian Klaussner
 */
public class FileProvider {
	public static final int CSS = 0, IMG = 1, JS = 2, JSP = 3, LIB = 4;
	
	private final String[] cssFiles = {
		"style.css"
	};
	
	private final String[] imgFiles = {
		"palladio.png"
	};
	
	private final String[] jsFiles = {
		"jquery-2.1.1.min.js", 
		"underscore-1.6.0.min.js"
	};
	
	private final String[] jspFiles = {
		"Main.jsp", 
		"RemoteRegistry.jsp"
	};
	
	private final String[] libFiles = {
		"commons-io-2.4.jar", 
		"commons-logging-1.1.3.jar", 
		"httpclient-4.1.3.jar", 
		"httpcore-4.1.4.jar", 
		"jackson-annotations-2.2.3.jar", 
		"jackson-core-2.2.3.jar", 
		"jackson-databind-2.2.3.jar", 
		"jstl-1.2.jar", 
		"org.palladiosimulator.protocom.framework.jar" 
	};
	
	private final String[][] files = {
		cssFiles, 
		imgFiles, 
		jsFiles, 
		jspFiles, 
		libFiles
	};
	
	private final String[] filePaths = {
		"css", 
		"img", 
		"js", 
		"jsp", 
		"lib"
	};
	
	/**
	 * Adds additional library dependencies from Java SE ProtoCom to a list of URLs.
	 * @param list the list of URLs to add the library dependencies to
	 */
	private void addLibraryDependencies(List<URL> list) {
		InputStream stream = getClass().getResourceAsStream("files/lib/dependencies/index.txt");
		BufferedReader index = new BufferedReader(new InputStreamReader(stream));
		
		String lib;
		
		try {
			while ((lib = index.readLine()) != null) {
				list.add(getClass().getResource("files/lib/dependencies/" + lib));
			}
			
			index.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Gets a list of web content file URLs for the specified file type.
	 * @param type the type of the files to be returned
	 * @return a list of URLs for all files of the specified type
	 */
	public List<URL> getFilesOfType(int type) {
		ArrayList<URL> urls = new ArrayList<URL>();
		
		for (String file : files[type]) {
			urls.add(getClass().getResource("files/" + filePaths[type] + "/" + file));
		}
		
		if (type == LIB) addLibraryDependencies(urls);
		
		return urls;
	}
}
