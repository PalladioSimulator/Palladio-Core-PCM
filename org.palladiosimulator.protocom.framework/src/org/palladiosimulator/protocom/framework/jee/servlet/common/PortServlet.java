package org.palladiosimulator.protocom.framework.jee.servlet.common;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;
import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleStartException;
import org.palladiosimulator.protocom.framework.jee.servlet.registry.RemoteCall;

/**
 * The PortServlet class is the common base class for ports.
 * @author Christian Klaussner
 */
public abstract class PortServlet<T> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected String location;
	protected T component;
	
	/**
	 * Starts the port and registers it.
	 * @return true if the port was started successfully, otherwise false
	 * @throws ModuleStartException
	 */
	public void start(String componentId, String assemblyContext) throws ModuleStartException {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		
		if (request.getParameter("action").equals("start")) {
			if (location == null) {
				location = request.getParameter("location");
			}
			
			StringResponse response = new StringResponse();
			
			try {
				//String componentId = request.getParameter("componentId");
				String assemblyContext = request.getParameter("assemblyContext");
				
				start(null, assemblyContext);
				response.setError(Response.OK);
			} catch (ModuleStartException e) {
				response.setError(Response.FAILED);
			}
			
			httpResponse.setContentType("application/json");
			httpResponse.getOutputStream().print(response.toJson());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringWriter call = new StringWriter();
		IOUtils.copy(request.getInputStream(), call);
		
		RemoteCall remoteCall = RemoteCall.fromJson(call.toString());
		remoteCall.dispatch(this);		
	}
}
