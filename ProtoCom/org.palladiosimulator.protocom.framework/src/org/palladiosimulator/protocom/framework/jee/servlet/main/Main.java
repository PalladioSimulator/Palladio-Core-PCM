package org.palladiosimulator.protocom.framework.jee.servlet.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.palladiosimulator.protocom.framework.AbstractAllocationStorage;
import org.palladiosimulator.protocom.framework.jee.servlet.common.Log;
import org.palladiosimulator.protocom.framework.jee.servlet.http.JsonResponse;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ContainerModule;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.Module;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleList;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleStartException;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.SystemModule;
import org.palladiosimulator.protocom.framework.jee.servlet.registry.Registry;

/**
 * The Main Servlet class is the entry point for the application and handles requests.
 * @author Christian Klaussner
 */
public abstract class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String location, registryLocation;
	private final ModuleList moduleList;
	
	/**
	 * Constructs a new Main Servlet.
	 */
	public Main() {
		moduleList = new ModuleList();
	}
	
	protected abstract String[] getSystem();
	protected abstract void initAllocationStorage();
	
	protected void addModule(Module module) {
		moduleList.add(module);
	}
	
	@Override
	public void init() throws ServletException {
		// Initialize allocation storage.
		initAllocationStorage();
		
		// Add modules to the list.
		String[] system = getSystem();
		moduleList.add(new SystemModule("1", system[1], system[0]));
		
		AbstractAllocationStorage.initContainer();
		
		for (String container : AbstractAllocationStorage.getContainerNames()) {
			String id = AbstractAllocationStorage.getContainerID(container);
			moduleList.add(new ContainerModule(id, container));
		}
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
	private Response startModule(String id) {
		Module module = moduleList.get(id);
		
		Response response;
		
		try {
			module.startModule(location);
			response = new Response(Response.OK);
		} catch (ModuleStartException e) {
			response = new Response(Response.FAILED);
		}
		
		return response;
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
				
			else if (action.equals("updateRegistryLocation")) {
				result = updateRegistryLocation(request.getParameter("location"));
			}
				
			else if (action.equals("getRegistryLocation")) {
				result = getRegistryLocation();
			}
				
			else if (action.equals("startModule")) {
				result = startModule(request.getParameter("id"));
			}
				
			else if (action.equals("getModules")) {
				result = getModules();
			}
			
			response.getOutputStream().print(result.toJson());
		}
	}
}
