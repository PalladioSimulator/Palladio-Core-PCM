package org.palladiosimulator.protocom.framework.webui;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.protocom.framework.webui.NanoHTTPD.Response.Status;

public class WebServer extends NanoHTTPD {
	private final HashMap<String, String> resources;
	private boolean running = false;
	
	class WebResource {
		private InputStream stream;
		private String mimeType;
		
		public WebResource(InputStream stream, String mimeType) {
			this.stream = stream;
			this.mimeType = mimeType;
		}
		
		public InputStream getInputStream() {
			return stream;
		}
		
		public String getMimeType() {
			return mimeType;
		}
	}
	
	public WebServer() {
		super(8080);
		
		resources = new HashMap<String, String>();
		
		resources.put("/", "html/Main.html");
		resources.put("/css/style.css", "css/style.css");
		resources.put("/img/palladio.png", "img/palladio.png");
		resources.put("/js/jquery-2.1.1.min.js", "js/jquery-2.1.1.min.js");
		resources.put("/js/underscore-1.6.0.min.js", "js/underscore-1.6.0.min.js");
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		if (session.getUri().equals("/isRunning")) {
			return new Response(Status.OK, "application/json", "{\"running\":" + running + "}");
		}
		
		if (session.getUri().equals("/getModules")) {
			StringBuilder json = new StringBuilder();
			
			json.append("[");
			json.append("{\"id\":0,\"permanent\":true,\"name\":\"Module Name\"}");
			json.append("]");
			
			return new Response(Status.OK, "application/json", json.toString());
		}
		
		if (session.getUri().equals("/")) {
			Map<String, String> parms = session.getParms();
			
			if (!parms.isEmpty()) {
				for (String key : parms.keySet()) {
					System.out.println(key + " : " + parms.get(key));
				}
				
				running = true;
				
				return new Response(Status.OK, "application/json", "{\"error\":0}");
			}
		}
		
		WebResource resource = getResourceForPath(session.getUri());
		
		if (resource != null) {
			return new Response(Status.OK, resource.getMimeType(), resource.getInputStream());
		} else {
			return new Response(Status.NOT_FOUND, "application/unknown", (InputStream)null);
		}
	}
	
	private String getMimeType(String path) {
		String mimeType = "";
		int dotIndex = path.lastIndexOf('.');
		
		if (dotIndex < 0) {
			mimeType = "text/html";
		} else {
			String extension = path.substring(dotIndex + 1);
			
			if(extension.equals("css")) {
				mimeType = "text/css";
			} else if (extension.equals("png")) {
				mimeType = "image/png";
			} else if (extension.equals("js")) {
				mimeType = "application/javascript";
			}
		}
		
		return mimeType;
	}
	
	private WebResource getResourceForPath(String path) {
		if (resources.containsKey(path)) {
			InputStream stream = this.getClass().getResourceAsStream("files/" + resources.get(path));
			return new WebResource(stream, getMimeType(path));
		} else {
			return null;
		}
	}
}
