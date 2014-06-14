package org.palladiosimulator.protocom.framework.webui;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.palladiosimulator.protocom.framework.AbstractAllocationStorage;
import org.palladiosimulator.protocom.framework.AbstractMain;
import org.palladiosimulator.protocom.framework.webui.NanoHTTPD.Response.Status;

public class WebServer extends NanoHTTPD {
	private final HashMap<String, String> resources;
	private final AbstractMain main;
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
	
	public WebServer(AbstractMain main) {
		super(8080);
		
		this.main = main;
		
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
			
			json.append(getJsonForModule(2, "RMI Registry"));
			json.append(",");
			json.append(getJsonForModule(3, "Usage Scenarios"));
			json.append(",");
			json.append(getJsonForModule(4, "System " + main.getSystemName()));
			
			Collection<String> containers = AbstractAllocationStorage.getContainerNames();
			int i = 5;
			
			for (String container : containers) {
				json.append(",");
				json.append(getJsonForModule(i++, "Container " + container));
			}
			
			json.append("]");
			
			System.out.println(json.toString());
			
			return new Response(Status.OK, "application/json", json.toString());
		}
		
		if (session.getUri().equals("/startModule")) {
			Map<String, String> parms = session.getParms();
			int id = 0;
			
			try {
				id = Integer.parseInt(parms.get("id"));
			} catch (NumberFormatException e) {
			}
			
			main.handleMenuItem(id);
			
			System.out.println("Module " + id + " started");
			
			return new Response(Status.OK, "application/json", "{\"error\":0}");
		}
		
		if (session.getUri().equals("/")) {
			Map<String, String> parms = session.getParms();
			
			if (!parms.isEmpty()) {
				ArrayList<String> args = new ArrayList<String>();
				
				for (String key : parms.keySet()) {
					if (!parms.get(key).isEmpty()) args.add("-" + key);
					
					if (!(key.equals("h") || key.equals("D") || key.equals("P") || key.equals("W"))) {
						args.add(parms.get(key));
					}					
				}
				
				running = true;
				
				String[] argsArray = new String[args.size()];
				args.toArray(argsArray);
				
				main.runWithParameters(argsArray, false);
				
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
	
	private String getJsonForModule(int id, String name) {
		StringBuilder json = new StringBuilder();
		
		json.append("{\"id\":");
		json.append(id);
		json.append(",\"permanent\":true");
		json.append(",\"name\":\"");
		json.append(name);
		json.append("\"}");
		
		return json.toString();
	}
}
