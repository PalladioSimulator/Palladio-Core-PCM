package org.palladiosimulator.protocom.framework.jee.servlet.webcontent;

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
	
	public List<URL> getFilesOfType(int type) {
		ArrayList<URL> urls = new ArrayList<URL>();
		
		for (String file : files[type]) {
			urls.add(getClass().getResource("files/" + filePaths[type] + "/" + file));
		}
		
		return urls;
	}
}
