package org.palladiosimulator.protocom.framework.jee.servlet.main;

import org.palladiosimulator.protocom.framework.jee.servlet.http.JsonResponse;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.palladiosimulator.protocom.framework.jee.servlet.modules.ComponentModule;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.Module;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleList;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.UsageScenarioModule;
import org.palladiosimulator.protocom.framework.jee.servlet.registry.Registry;

import org.palladiosimulator.protocom.framework.jee.servlet.common.Log;

/**
 * The Main Servlet class is the entry point for the application and handles requests.
 * @author Christian Klaussner
 */
@WebServlet(urlPatterns = "", loadOnStartup = 0)
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String location, registryLocation;
	private ModuleList moduleList;

	@Override
	public void init() throws ServletException {
		moduleList = new ModuleList();
		
		moduleList.add(new ComponentModule("1", "Bob Component", "/IBobPort"));
		moduleList.add(new ComponentModule("2", "Alice Component", "/IAlicePort"));
		// moduleList.add(new UsageScenarioModule("3", "Usage Scenario", new UsageScenario()));
	}
	
	/**
	 * Returns the integer representation of the specified request parameter.
	 * @param request the request that the parameter belongs to
	 * @param name the name of the parameter
	 * @return the integer representation of the parameter
	 */
	private int getIntParameter(HttpServletRequest request, String name) {
		int value = 0;
		
		try {
			value = Integer.parseInt(request.getParameter(name));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	// The following methods are request handlers.
	
	/**
	 * Gets the messages from the log.
	 * @param base the starting index of the log messages
	 * @return the response of the operation
	 */
	private JsonResponse getLog(int base) {
		JsonResponse response = new JsonResponse(Log.getInstance().toJson(base));
		return response;
	}
	
	/**
	 * Updates the location URL of the registry.
	 * @return the response of the operation
	 */
	private Response updateRegistryLocation(String location) {
		registryLocation = location;
		Registry.setLocation(registryLocation);
		
		return new Response(Response.OK);
	}
	
	/**
	 * Gets the location URL of the registry.
	 * @return the response of the operation
	 */
	private StringResponse getRegistryLocation() {
		StringResponse response = new StringResponse(registryLocation);
		return response;
	}
	
	/**
	 * Starts the module with the specified ID.
	 * @param id the ID of the module to start
	 * @return the response of the operation
	 */
	private Response startModule(int id) {
		Module module = moduleList.get(Integer.toString(id));
		return module.startModule(location);
		
		
		/*ArrayList<Parameter> parameters = new ArrayList<Parameter>(2);
		parameters.add(new Parameter("action", "start"));
		parameters.add(new Parameter("location", location));
		
		String responseString = "";
		
		switch (id) {
		case 1:
			responseString = Request.get(location, "/IAlicePort", parameters);
			response = StringResponse.fromJson(responseString);
			break;

		case 2:
			responseString = Request.get(location, "/IBobPort", parameters);
			response = StringResponse.fromJson(responseString);
			break;
			
		case 3:
			response = new StringResponse();
			
			try {
				IAlice alice = (IAlice)Registry.lookup("IAlice");
				alice.callBob();
				
				response.setError(Response.OK);
			} catch (RegistryException e) {
				Log.error(e.getMessage());
				response.setError(Response.FAILED);
			}
			
			break;
		}
		
		return response;*/
	}
	
	/**
	 * Gets the list of modules.
	 * @return the response of the operation
	 */
	private JsonResponse getModules() {
		JsonResponse response = new JsonResponse(moduleList.toJson());
		return response;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Update the location URL.
		location = request.getRequestURL().toString();
		
		if (registryLocation == null) {
			registryLocation = location;
			Registry.setLocation(registryLocation);
		}
		
		// Dispatch the request action.
		String action = request.getParameter("action");
		
		if (action == null) {
			request.setAttribute("location", registryLocation);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
			dispatcher.forward(request, response);
		} else {
			Response result = null;
			response.setContentType("application/json");
			
			if (action.equals("getLog")) {
				result = getLog(getIntParameter(request, "base"));
			}
				
			if (action.equals("updateRegistryLocation")) {
				result = updateRegistryLocation(request.getParameter("location"));
			}
				
			if (action.equals("getRegistryLocation")) {
				result = getRegistryLocation();
			}
				
			if (action.equals("startModule")) {
				result = startModule(getIntParameter(request, "id"));
			}
				
			if (action.equals("getModules")) {
				result = getModules();
			}
			
			response.getOutputStream().print(result.toJson());
		}
	}
}
