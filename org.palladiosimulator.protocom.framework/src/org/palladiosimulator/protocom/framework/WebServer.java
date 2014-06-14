package org.palladiosimulator.protocom.framework;

import java.io.InputStream;
import java.util.HashMap;

public class WebServer extends NanoHTTPD {
	private final HashMap<String, String> resources;
	
	public WebServer() {
		super(8080);
		
		resources = new HashMap<String, String>();
		
		resources.put("/", "html/Main.html");
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		System.out.println(session.getUri());
		
		NanoHTTPD.Response response = new Response(NanoHTTPD.Response.Status.OK, MIME_HTML, getResourceForPath(session.getUri()));
		return response;
		//return new NanoHTTPD.Response(":)");
	}
	
	private InputStream getResourceForPath(String path) {
		if (resources.containsKey(path)) {
			return this.getClass().getResourceAsStream(resources.get("webui/files/" + path));
		} else {
			return null;
		}
	}
}
