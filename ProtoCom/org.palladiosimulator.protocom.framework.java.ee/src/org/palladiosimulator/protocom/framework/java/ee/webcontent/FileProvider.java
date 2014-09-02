package org.palladiosimulator.protocom.framework.java.ee.webcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileProvider class is used to retrieve WebContent files during transformation.
 * @author Christian Klaussner
 */
public class FileProvider {
	public static final int CSS = 0, FONTS = 1, IMG = 2, JS = 3, JSP = 4, LIB = 5;

	private final String[] cssFiles = {
		"font-awesome.min.css",
		"style.css"
	};

	private final String[] fontFiles = {
		"fontawesome-webfont.eot",
		"fontawesome-webfont.svg",
		"fontawesome-webfont.ttf",
		"fontawesome-webfont.woff",
		"FontAwesome.otf"
	};

	private final String[] imgFiles = {
		"palladio.png"
	};

	private final String[] jsFiles = {
		"lib/backbone-1.1.2.min.js",
		"lib/jquery-2.1.1.min.js",
		"lib/underscore-1.6.0.min.js",
		"calibration.js",
		"code.js",
		"log.js",
		"modules.js",
		"options.js",
		"registry.js",
		"results.js",
		"scenarios.js"
	};

	private final String[] jspFiles = {
		"Main.jsp",
		"RemoteRegistry.jsp"
	};

	private final String[] libFiles = {
		"asm-3.1.jar",
		"commons-io-2.4.jar",
		"commons-logging-1.1.3.jar",
		"de.uka.ipd.sdq.sensorframework_1.1.0.201408041822.jar",
		"de.uka.ipd.sdq.sensorframework.storage_1.0.0.201408041822.jar",
		"httpclient-4.1.3.jar",
		"httpcore-4.1.4.jar",
		"jackson-annotations-2.2.3.jar",
		"jackson-core-2.2.3.jar",
		"jackson-databind-2.2.3.jar",
		"jersey-bundle-1.8.jar",
		"jscience.jar",
		"jsr311-api-1.1.jar",
		"jstl-1.2.jar",
		"org.palladiosimulator.protocom.framework.java.ee.jar",
		"org.palladiosimulator.protocom.resourcestrategies.ee.jar"
	};

	private final String[][] files = {
		cssFiles,
		fontFiles,
		imgFiles,
		jsFiles,
		jspFiles,
		libFiles
	};

	private final String[] filePaths = {
		"css",
		"fonts",
		"img",
		"js",
		"jsp",
		"lib"
	};

	/**
	 * Adds additional library dependencies from Java SE ProtoCom to a list of URLs.
	 * Currently unused due to dependency issues with SAP HANA Cloud.
	 * @param list the list of URLs to add the library dependencies to
	 */
	@SuppressWarnings("unused")
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

		return urls;
	}
}
