package org.palladiosimulator.protocom.framework.java.ee.webcontent;

import java.net.URL;

public class FrameworkFile {
	private final URL url;
	private final String path;

	public FrameworkFile(URL url, String path) {
		this.url = url;
		this.path = path;
	}

	public URL getUrl() {
		return url;
	}

	public String getPath() {
		return path;
	}
}
