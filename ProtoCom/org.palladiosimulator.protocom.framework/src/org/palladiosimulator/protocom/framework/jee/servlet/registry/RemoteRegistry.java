package org.palladiosimulator.protocom.framework.jee.servlet.registry;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The RemoteRegistry class manages the registry.
 * @author Christian Klaussner
 */
@WebServlet(urlPatterns = "/Registry", loadOnStartup = 0)
public class RemoteRegistry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static HashMap<String, RegistryEntry> registeredObjects;
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	@Override
	public void init() throws ServletException {
		registeredObjects = new HashMap<String, RegistryEntry>();
	}
	
	/**
	 * Converts the specified object to JSON.
	 * @param object the object to convert
	 * @return a JSON object string representing the object
	 */
	private String objectToJson(Object object) {
		String json = "";
		
		try {
			json = MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	/**
	 * Registers an object.
	 * @param entryString the serialized RegistryEntry object to register
	 * @return the response of the operation
	 */
	private Response register(String entryString) {
		StringResponse response = new StringResponse();
		
		RegistryEntry entry = null;
		
		try {
			entry = MAPPER.readValue(entryString, RegistryEntry.class);
			
			if (registeredObjects.containsKey(entry.getName())) {
				response.setError(Response.ALREADY_EXISTS);
			} else {
				response.setError(Response.OK);
				registeredObjects.put(entry.getName(), entry);
			}
		} catch (IOException e) {
			response.setError(Response.INVALID);
		}
		
		return response;
	}
	
	/**
	 * Unregisters an object.
	 * @param name the name of the object to unregister
	 * @return the response of the operation
	 */
	private Response unregister(String name) {
		StringResponse response = new StringResponse();
		
		if (registeredObjects.containsKey(name)) {
			response.setError(Response.OK);
			registeredObjects.remove(name);
		} else {
			response.setError(Response.INVALID);
		}
		
		return response;
	}
	
	/**
	 * Looks up an object.
	 * @param name the name of the object to look up
	 * @return the response of the operation
	 */
	private Response lookup(String name) {
		StringResponse response = new StringResponse();
		
		RegistryEntry entry = registeredObjects.get(name);
		
		if (entry != null) {
			response.setError(StringResponse.OK);
			response.setPayload(objectToJson(entry));
		} else {
			response.setError(StringResponse.ALREADY_EXISTS);
		}
		
		return response;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("registeredObjects", registeredObjects);
		
		String action = request.getParameter("action");
		
		if (action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/RemoteRegistry.jsp");
			dispatcher.forward(request, response);
		} else {
			Response result = null;
			response.setContentType("application/json");
			
			if (action.equals("register")) {
				result = register(request.getParameter("entry"));
			} else if (action.equals("unregister")) {
				result = unregister(request.getParameter("name"));
			} else if (action.equals("lookup")) {
				result = lookup(request.getParameter("name"));
			}
		
			response.getOutputStream().print(result.toJson());
		}
	}
}
