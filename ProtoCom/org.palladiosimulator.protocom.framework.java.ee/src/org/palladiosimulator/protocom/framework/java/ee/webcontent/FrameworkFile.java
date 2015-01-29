package org.palladiosimulator.protocom.framework.java.ee.webcontent;

import java.net.URL;

/**
 * The FrameworkFile class stores the data required for copying a framework file.
 * @author Christian Klaussner
 */
public class FrameworkFile {
	private final URL url;
	private final String path;

	/**
	 * Constructs a new FrameworkFile object.
	 * @param url the source URL
	 * @param path the destination path
	 */
	public FrameworkFile(URL url, String path) {
		this.url = url;
		this.path = path;
	}

	/**
	 * Gets the source URL.
	 * @return the source URL
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * Gets the destination path.
	 * @return the destination path
	 */
	public String getPath() {
		return path;
	}
}
